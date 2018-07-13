package poslovna_banka.service;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.Bank;
import poslovna_banka.model.BankAccount;
import poslovna_banka.model.Clearing;
import poslovna_banka.model.DailyAccountState;
import poslovna_banka.model.Rtgs;
import poslovna_banka.repository.AnalyticOfStatementRepository;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.DailyAccountStateRepository;
import poslovna_banka.repository.PaymentTypeRepository;
import poslovna_banka.xml.RtgsXml;

@Service
public class AnalyticsOfStatementService {

	private final double maxSum= 250000;
	
	@Autowired
	private AnalyticOfStatementRepository analyticRepository;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	@Autowired
	private DailyAccountStateRepository dailyAccountStateRepository;
	
	@Autowired
	private ClearingService clearingService;
	
	@Autowired
	private RtgsService rtgsService;
	

	// ucitaj nalog za isplatu
	public AnalyticOfStatement getAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = generateAnalyticsOfStatement(xml);
		return a;

	}

	// nalog za isplatu snimi
	public AnalyticOfStatement saveAnalyticsOfStatements(File file) throws JAXBException, ParseException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = this.generateAnalyticsOfStatement(xml);
		analyticRepository.save(a);

		if (a.getType().equals("Nalog za isplatu")) {
			BankAccount debtorAccount = bankAccountRepository.findOne(a.getDebtorAccount().getId());
			DailyAccountState dailyAccountState = dailyAccountStateRepository
					.findOneByDateAndBankAccount(a.getCurrencyDate(), debtorAccount);

			if (dailyAccountState == null) {

				ArrayList<DailyAccountState> states = dailyAccountStateRepository.findAllByBankAccount(debtorAccount);
				// ako ne postoji ni jedno dnevno stanje za dati racun , nije
				// moguce izvrstiti isplatu jer je stanje na rucnu 0
				if (states == null) {
					throw new IllegalArgumentException("Ne posotoji dovoljno novca za isplatu !");
				} else {
					// pronaci najveci datum dnevnog stanja racuna
					DailyAccountState max = states.get(0);

					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					Date maxDate = date.parse(states.get(0).getDate());

					Date fromDate = date.parse(a.getCurrencyDate());

					for (int i = 1; i < states.size(); i++) {
						Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountState dailyAccountStateNew = new DailyAccountState();
					dailyAccountStateNew.setBankAccount(debtorAccount);
					dailyAccountStateNew.setPreviousState(max.getNewState());
					dailyAccountStateNew.setNewState(0.0);
					dailyAccountStateNew.setPaymentFrom(0.0);
					dailyAccountStateNew.setPaymentTo(0.0);
					dailyAccountStateNew.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateNew);

					dailyAccountStateNew.setPaymentFrom(dailyAccountStateNew.getPaymentFrom() + a.getSum());
					dailyAccountStateNew.setNewState(dailyAccountStateNew.getPreviousState()
							+ dailyAccountStateNew.getPaymentTo() - dailyAccountStateNew.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateNew);

					a.setDailyAccountState(dailyAccountStateNew);
					analyticRepository.save(a);
				}

			} else {

				if (a.getSum() > dailyAccountState.getNewState()) {

					throw new IllegalArgumentException("Ne posotoji dovoljno novca za isplatu !");

				}
				dailyAccountState.setPaymentFrom(dailyAccountState.getPaymentFrom() + a.getSum());
				dailyAccountState.setNewState(dailyAccountState.getPreviousState() + dailyAccountState.getPaymentTo()
						- dailyAccountState.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountState);

				a.setDailyAccountState(dailyAccountState);
				analyticRepository.save(a);

			}

		}
		return a;

	}

	public AnalyticOfStatement getPaymentAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = generatePaymentAnalyticsOfStatement(xml);
		analyticRepository.save(a);

		return a;
	}

	// Nalog za isplatu
	private AnalyticOfStatement generateAnalyticsOfStatement(AnalyticOfStatement xml) throws JAXBException {
		AnalyticOfStatement a = new AnalyticOfStatement();
		a.setType(xml.getType());
		a.setDebtor(xml.getDebtor());
		a.setPurposeOfPayment(xml.getPurposeOfPayment());
		a.setCreditor(xml.getCreditor());
		a.setDateOfReceipt(xml.getDateOfReceipt());
		a.setCurrencyDate(xml.getCurrencyDate());
		a.setSum(xml.getSum());
		a.setDebtorAccount(bankAccountRepository.findOneByNumber(xml.getDebtorAccountXML()));
		a.setModelAssigments(xml.getModelAssigments());
		a.setReferenceNumberAssigments(xml.getReferenceNumberAssigments());
		a.setEmergency(xml.getEmergency());
		a.setTypeOfMistake(xml.getTypeOfMistake());
		a.setStatus(xml.getStatus());
		a.setPaymentType(paymentTypeRepository.findOneByCode(xml.getPaymentTypeXML()));
		a.setPaymentCurrency(currencyRepository.findOneByOfficialCode(xml.getPaymentCurrencyXML()));
		a.setCity(cityRepository.findOneByName(xml.getCityXML()));
		System.out.println("aaaaaa  " + paymentTypeRepository.findOneByCode(xml.getPaymentTypeXML())
				+ currencyRepository.findOneByOfficialCode(xml.getPaymentCurrencyXML()));
		a.setCode(xml.getCode());


		return a;
	}

	// nalog za naplatu sacuvaj
	//Bozicu, trebas dodati proveru ako je iznos veci od 250000 da kupis i te naloge i ako su racuni iz razlicitih banaka
	public AnalyticOfStatement saveAnalyticsOfStatementsPayment(File file) throws JAXBException, ParseException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = this.generatePaymentAnalyticsOfStatement(xml);
		analyticRepository.save(a);

		if (a.getType().equals("Nalog za naplatu")) {
			BankAccount debtorAccount = bankAccountRepository.findOne(a.getDebtorAccount().getId());
			BankAccount creditorAccount = bankAccountRepository.findOne(a.getAccountCreditor().getId());
			DailyAccountState dailyAccountState = dailyAccountStateRepository
					.findOneByDateAndBankAccount(a.getDateOfReceipt(), debtorAccount);
			DailyAccountState dailyAccountStateCreditor = dailyAccountStateRepository
					.findOneByDateAndBankAccount(a.getDateOfReceipt(), creditorAccount);

			if (dailyAccountState == null) {
				ArrayList<DailyAccountState> states = dailyAccountStateRepository.findAllByBankAccount(debtorAccount);
				// ako ne postoji ni jedno dnevno stanje za dati racun , nije
				// moguce izvrstiti isplatu jer je stanje na rucnu 0
				if (states == null) {
					throw new IllegalArgumentException("Ne posotoji dovoljno novca za naplatu !");
				} else {
					// pronaci najveci datum dnevnog stanja racuna
					DailyAccountState max = states.get(0);

					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					Date maxDate = date.parse(states.get(0).getDate());

					Date fromDate = date.parse(a.getCurrencyDate());

					for (int i = 1; i < states.size(); i++) {
						Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountState dailyAccountStateDebtor = new DailyAccountState();
					// setovanje dailyState za duznika
					dailyAccountStateDebtor.setBankAccount(debtorAccount);
					dailyAccountStateDebtor.setPreviousState(max.getNewState());
					dailyAccountStateDebtor.setNewState(0.0);
					dailyAccountStateDebtor.setPaymentFrom(0.0);
					dailyAccountStateDebtor.setPaymentTo(0.0);
					dailyAccountStateDebtor.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateDebtor);

					dailyAccountStateDebtor.setPaymentFrom(dailyAccountStateDebtor.getPaymentFrom() + a.getSum());

					dailyAccountStateDebtor.setNewState(dailyAccountStateDebtor.getPreviousState()
							+ dailyAccountStateDebtor.getPaymentTo() - dailyAccountStateDebtor.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateDebtor);

					a.setDailyAccountState(dailyAccountStateDebtor);
					analyticRepository.save(a);
				}

			} else {

				if (a.getSum() > dailyAccountState.getNewState()) {

					throw new IllegalArgumentException("Ne posotoji dovoljno novca za naplatu !");

				}
				
				System.out.println("Duznik payment from(-): " + dailyAccountState.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje duznika: " + dailyAccountState.getPreviousState());
				System.out.println("Duznik payment to(+): " + dailyAccountState.getPaymentTo());

				dailyAccountState.setPaymentFrom(dailyAccountState.getPaymentFrom() + a.getSum());
				dailyAccountState.setNewState(dailyAccountState.getPreviousState() + dailyAccountState.getPaymentTo()
						- dailyAccountState.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountState);

				System.out.println("Duznik payment from(-):  " + dailyAccountState.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje duznika: " + dailyAccountState.getPreviousState());
				System.out.println("Duznik payment to(+): " + dailyAccountState.getPaymentTo());

				a.setDailyAccountState(dailyAccountState);
				analyticRepository.save(a);

			}

			if (dailyAccountStateCreditor == null) {
				ArrayList<DailyAccountState> states = dailyAccountStateRepository.findAllByBankAccount(creditorAccount);
				// ako postoje dnevna stanja za dati racun
				// pronaci najveci datum dnevnog stanja racuna
				if (states.size() != 0) {
					DailyAccountState max = states.get(0);

					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					Date maxDate = date.parse(states.get(0).getDate());

					Date fromDate = date.parse(a.getCurrencyDate());

					for (int i = 1; i < states.size(); i++) {
						Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountState dailyAccountStateCred = new DailyAccountState();
					// setovanje dailyState za poverioca
					dailyAccountStateCred.setBankAccount(creditorAccount);
					dailyAccountStateCred.setPreviousState(max.getNewState());
					dailyAccountStateCred.setNewState(0.0);
					dailyAccountStateCred.setPaymentFrom(0.0);
					dailyAccountStateCred.setPaymentTo(0.0);
					dailyAccountStateCred.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateCred);

					dailyAccountStateCred.setPaymentTo(dailyAccountStateCred.getPaymentTo() + a.getSum());

					dailyAccountStateCred.setNewState(dailyAccountStateCred.getPreviousState()
							+ dailyAccountStateCred.getPaymentTo() - dailyAccountStateCred.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateCred);

					a.setDailyAccountState(dailyAccountStateCred);
					analyticRepository.save(a);
				} else {
					DailyAccountState dailyAccountStateNewCreditor = new DailyAccountState();
					// setovanje dailyState za poverioca kad ne postoji nijedno
					// dnevno stanje za njega
					dailyAccountStateNewCreditor.setBankAccount(creditorAccount);
					dailyAccountStateNewCreditor.setPreviousState(0.0);
					dailyAccountStateNewCreditor.setNewState(0.0);
					dailyAccountStateNewCreditor.setPaymentFrom(0.0);
					dailyAccountStateNewCreditor.setPaymentTo(0.0);
					dailyAccountStateNewCreditor.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateNewCreditor);

					dailyAccountStateNewCreditor.setPaymentTo(dailyAccountStateNewCreditor.getPaymentTo() + a.getSum());

					dailyAccountStateNewCreditor.setNewState(dailyAccountStateNewCreditor.getPreviousState()
							+ dailyAccountStateNewCreditor.getPaymentTo() - dailyAccountStateNewCreditor.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateNewCreditor);

					a.setDailyAccountState(dailyAccountStateNewCreditor);
					analyticRepository.save(a);
				}

			} else {

				System.out.println("Payment from poverioca(+): " + dailyAccountState.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje poverioca: " + dailyAccountState.getPreviousState());
				System.out.println("Payment to poverioca(-): " + dailyAccountState.getPaymentTo());

				dailyAccountStateCreditor.setPaymentTo(dailyAccountStateCreditor.getPaymentTo() + a.getSum());
				dailyAccountStateCreditor.setNewState(dailyAccountStateCreditor.getPreviousState() + dailyAccountStateCreditor.getPaymentTo()
						- dailyAccountStateCreditor.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountStateCreditor);

				System.out.println("Payment from poverioca(+): " + dailyAccountStateCreditor.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje poverioca: " + dailyAccountStateCreditor.getPreviousState());
				System.out.println("Payment to poverioca(-): " + dailyAccountStateCreditor.getPaymentTo());

				a.setDailyAccountState(dailyAccountStateCreditor);
				analyticRepository.save(a);

			}

		}
			
		return a;

	}
	
	// nalog za prenos sacuvaj
	public AnalyticOfStatement saveAnalyticsOfStatementsTransfer(File file) throws JAXBException, ParseException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = this.generatePaymentAnalyticsOfStatement(xml);
		analyticRepository.save(a);
		
		if(a.getEmergency()) {
			//Bozicu, dodaj sta ti sve treba za rtgs i kliring ovde(poruke MT102 ili MT103 )
		}

		if (a.getType().equals("Nalog za prenos")) {
			BankAccount debtorAccount = bankAccountRepository.findOne(a.getDebtorAccount().getId());
			BankAccount creditorAccount = bankAccountRepository.findOne(a.getAccountCreditor().getId());
			DailyAccountState dailyAccountState = dailyAccountStateRepository
					.findOneByDateAndBankAccount(a.getDateOfReceipt(), debtorAccount);
			DailyAccountState dailyAccountStateCreditor = dailyAccountStateRepository
					.findOneByDateAndBankAccount(a.getDateOfReceipt(), creditorAccount);

			if (dailyAccountState == null) {
				ArrayList<DailyAccountState> states = dailyAccountStateRepository.findAllByBankAccount(debtorAccount);
				// ako ne postoji ni jedno dnevno stanje za dati racun , nije
				// moguce izvrstiti prenos jer je stanje na rucnu 0
				if (states == null) {
					throw new IllegalArgumentException("Ne posotoji dovoljno novca za naplatu !");
				} else {
					// pronaci najveci datum dnevnog stanja racuna
					DailyAccountState max = states.get(0);

					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					Date maxDate = date.parse(states.get(0).getDate());

					Date fromDate = date.parse(a.getCurrencyDate());

					for (int i = 1; i < states.size(); i++) {
						Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountState dailyAccountStateDebtor = new DailyAccountState();
					// setovanje dailyState za duznika
					dailyAccountStateDebtor.setBankAccount(debtorAccount);
					dailyAccountStateDebtor.setPreviousState(max.getNewState());
					dailyAccountStateDebtor.setNewState(0.0);
					dailyAccountStateDebtor.setPaymentFrom(0.0);
					dailyAccountStateDebtor.setPaymentTo(0.0);
					dailyAccountStateDebtor.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateDebtor);

					dailyAccountStateDebtor.setPaymentFrom(dailyAccountStateDebtor.getPaymentFrom() + a.getSum());

					dailyAccountStateDebtor.setNewState(dailyAccountStateDebtor.getPreviousState()
							+ dailyAccountStateDebtor.getPaymentTo() - dailyAccountStateDebtor.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateDebtor);

					a.setDailyAccountState(dailyAccountStateDebtor);
					analyticRepository.save(a);
				}

			} else {

				if (a.getSum() > dailyAccountState.getNewState()) {

					throw new IllegalArgumentException("Ne posotoji dovoljno novca za naplatu !");

				}
				
				System.out.println("Duznik payment from(-): " + dailyAccountState.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje duznika: " + dailyAccountState.getPreviousState());
				System.out.println("Duznik payment to(+): " + dailyAccountState.getPaymentTo());

				dailyAccountState.setPaymentFrom(dailyAccountState.getPaymentFrom() + a.getSum());
				dailyAccountState.setNewState(dailyAccountState.getPreviousState() + dailyAccountState.getPaymentTo()
						- dailyAccountState.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountState);

				System.out.println("Duznik payment from(-):  " + dailyAccountState.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje duznika: " + dailyAccountState.getPreviousState());
				System.out.println("Duznik payment to(+): " + dailyAccountState.getPaymentTo());

				a.setDailyAccountState(dailyAccountState);
				analyticRepository.save(a);

			}

			if (dailyAccountStateCreditor == null) {
				ArrayList<DailyAccountState> states = dailyAccountStateRepository.findAllByBankAccount(creditorAccount);
				// ako postoje dnevna stanja za dati racun
				// pronaci najveci datum dnevnog stanja racuna
				if (states.size() != 0) {
					DailyAccountState max = states.get(0);

					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					Date maxDate = date.parse(states.get(0).getDate());

					Date fromDate = date.parse(a.getCurrencyDate());

					for (int i = 1; i < states.size(); i++) {
						Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountState dailyAccountStateCred = new DailyAccountState();
					// setovanje dailyState za poverioca
					dailyAccountStateCred.setBankAccount(creditorAccount);
					dailyAccountStateCred.setPreviousState(max.getNewState());
					dailyAccountStateCred.setNewState(0.0);
					dailyAccountStateCred.setPaymentFrom(0.0);
					dailyAccountStateCred.setPaymentTo(0.0);
					dailyAccountStateCred.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateCred);

					dailyAccountStateCred.setPaymentTo(dailyAccountStateCred.getPaymentTo() + a.getSum());

					dailyAccountStateCred.setNewState(dailyAccountStateCred.getPreviousState()
							+ dailyAccountStateCred.getPaymentTo() - dailyAccountStateCred.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateCred);

					a.setDailyAccountState(dailyAccountStateCred);
					analyticRepository.save(a);
				} else {
					DailyAccountState dailyAccountStateNewCreditor = new DailyAccountState();
					// setovanje dailyState za poverioca kad ne postoji nijedno
					// dnevno stanje za njega
					dailyAccountStateNewCreditor.setBankAccount(creditorAccount);
					dailyAccountStateNewCreditor.setPreviousState(0.0);
					dailyAccountStateNewCreditor.setNewState(0.0);
					dailyAccountStateNewCreditor.setPaymentFrom(0.0);
					dailyAccountStateNewCreditor.setPaymentTo(0.0);
					dailyAccountStateNewCreditor.setDate(a.getCurrencyDate());
					dailyAccountStateRepository.save(dailyAccountStateNewCreditor);

					dailyAccountStateNewCreditor.setPaymentTo(dailyAccountStateNewCreditor.getPaymentTo() + a.getSum());

					dailyAccountStateNewCreditor.setNewState(dailyAccountStateNewCreditor.getPreviousState()
							+ dailyAccountStateNewCreditor.getPaymentTo() - dailyAccountStateNewCreditor.getPaymentFrom());

					dailyAccountStateRepository.save(dailyAccountStateNewCreditor);

					a.setDailyAccountState(dailyAccountStateNewCreditor);
					analyticRepository.save(a);
				}

			} else {

				System.out.println("Payment from poverioca(+): " + dailyAccountState.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje poverioca: " + dailyAccountState.getPreviousState());
				System.out.println("Payment to poverioca(-): " + dailyAccountState.getPaymentTo());

				dailyAccountStateCreditor.setPaymentTo(dailyAccountStateCreditor.getPaymentTo() + a.getSum());
				dailyAccountStateCreditor.setNewState(dailyAccountStateCreditor.getPreviousState() + dailyAccountStateCreditor.getPaymentTo()
						- dailyAccountStateCreditor.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountStateCreditor);

				System.out.println("Payment from poverioca(+): " + dailyAccountStateCreditor.getPaymentFrom());
				System.out.println("Iznos: " + a.getSum());
				System.out.println("Prethodno stanje poverioca: " + dailyAccountStateCreditor.getPreviousState());
				System.out.println("Payment to poverioca(-): " + dailyAccountStateCreditor.getPaymentTo());

				a.setDailyAccountState(dailyAccountStateCreditor);
				analyticRepository.save(a);

			}

		}

		return a;

	}

	// nalog za naplatu
	private AnalyticOfStatement generatePaymentAnalyticsOfStatement(AnalyticOfStatement xml) {
		AnalyticOfStatement a = new AnalyticOfStatement();

		a.setDateOfReceipt(xml.getDateOfReceipt());
		a.setCurrencyDate(xml.getCurrencyDate());
		a.setType(xml.getType());
		a.setDebtor(xml.getDebtor());
		a.setPurposeOfPayment(xml.getPurposeOfPayment());
		a.setCreditor(xml.getCreditor());
		a.setSum(xml.getSum());
		a.setDebtorAccount(bankAccountRepository.findOneByNumber(xml.getDebtorAccountXML()));
		a.setPaymentCurrency(currencyRepository.findOneByOfficialCode(xml.getPaymentCurrencyXML()));
		a.setModelAssigments(xml.getModelAssigments());
		a.setReferenceNumberAssigments(xml.getReferenceNumberAssigments());
		a.setAccountCreditor(bankAccountRepository.findOneByNumber(xml.getAccountCreditorXML()));
		a.setModelApproval(xml.getModelApproval());
		a.setReferenceNumberCreditor(xml.getReferenceNumberCreditor());
		a.setTypeOfMistake(xml.getTypeOfMistake());
		a.setStatus(xml.getStatus());
		a.setCode(xml.getCode());
		a.setEmergency(xml.getEmergency());

		return a;
	}
	
	public void generateBankTransfer(AnalyticOfStatement a ) throws JAXBException {
		Bank fromBank = a.getAccountCreditor().getBank();
		Bank toBank = a.getDebtorAccount().getBank();
		
		if(fromBank.getId() == toBank.getId() ) {
			return;
		}
		
		if(a.getSum() < maxSum && !a.getEmergency()) {
			Clearing clearing = clearingService.getLastClearingForBank(fromBank.getId(), toBank.getId());
			if(clearing == null) {
				List<AnalyticOfStatement> analytics = new ArrayList<>();
				analytics.add(a);
				clearing = new Clearing(fromBank,toBank,a.getPaymentCurrency(), a.getCurrencyDate(), analytics, a.getSum());
			}else {
				List<AnalyticOfStatement> analytics = clearing.getPayments();
				analytics.add(a);
				double sumAll = clearing.getSumAll();
				sumAll += a.getSum();
				clearing.setSumAll(sumAll);
				clearing.setPayments(analytics);
				clearingService.removeClearing(clearing.getId());
			}
			clearingService.saveClearing(clearing);
			
		}else {
			Rtgs newRtgs = new Rtgs(fromBank, toBank, a);
			newRtgs = rtgsService.addRtgs(newRtgs);
			generateXmlRTGS(newRtgs);
		}
	
	}
	
	private void generateXmlRTGS(Rtgs rtgs) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RtgsXml.class);
		Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		File file =new File("nalozi//rtgs//rtgs" +rtgs.getId()+".xml");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.marshal(new RtgsXml(rtgs), file );
	}

}
