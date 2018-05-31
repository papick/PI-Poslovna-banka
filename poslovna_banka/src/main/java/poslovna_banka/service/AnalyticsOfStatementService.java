package poslovna_banka.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.BankAccount;
import poslovna_banka.model.DailyAccountState;
import poslovna_banka.repository.AnalyticOfStatementRepository;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.DailyAccountStateRepository;
import poslovna_banka.repository.LegalEntityRepository;
import poslovna_banka.repository.PaymentTypeRepository;

@Service
public class AnalyticsOfStatementService {

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

	public AnalyticOfStatement getAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = generateAnalyticsOfStatement(xml);
		return a;

	}

	public AnalyticOfStatement saveAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = generateAnalyticsOfStatement(xml);
		analyticRepository.save(a);

		if (a.getType().equals("Nalog za isplatu")) {
			BankAccount debtorAccount = bankAccountRepository.findOne(a.getDebtorAccount().getId());
			DailyAccountState dailyAccountState = dailyAccountStateRepository
					.findOneByDateAndBankAccount(a.getCurrencyDate(), debtorAccount);

			if (dailyAccountState == null) {

				DailyAccountState dailyAccountStateNew = new DailyAccountState();

				// pocetno stanje

				dailyAccountStateNew.setPaymentFrom(dailyAccountStateNew.getPaymentTo() + a.getSum());
				dailyAccountStateNew.setNewState(dailyAccountStateNew.getPreviousState()
						+ dailyAccountStateNew.getPaymentTo() - dailyAccountStateNew.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountStateNew);

			} else {

				if(a.getSum() > dailyAccountState.getNewState()){

					throw new IllegalArgumentException("Ne posotoji dovoljno novca za isplatu !");

				}
				dailyAccountState.setPaymentFrom(dailyAccountState.getPaymentTo() + a.getSum());
				dailyAccountState.setNewState(dailyAccountState.getPreviousState() + dailyAccountState.getPaymentTo()
						- dailyAccountState.getPaymentFrom());

				dailyAccountStateRepository.save(dailyAccountState);

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

	private AnalyticOfStatement generateAnalyticsOfStatement(AnalyticOfStatement xml) {
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

		return a;
	}

	private AnalyticOfStatement generatePaymentAnalyticsOfStatement(AnalyticOfStatement xml) {
		AnalyticOfStatement a = new AnalyticOfStatement();

		a.setType(xml.getType());
		a.setDebtor(xml.getDebtor());
		a.setPurposeOfPayment(xml.getPurposeOfPayment());
		a.setCreditor(xml.getCreditor());
		a.setSum(xml.getSum());
		a.setDebtorAccount(bankAccountRepository.findOneByNumber(xml.getDebtorAccountXML()));
		a.setModelAssigments(xml.getModelAssigments());
		a.setReferenceNumberAssigments(xml.getReferenceNumberAssigments());
		a.setAccountCreditor(bankAccountRepository.findOneByNumber(xml.getAccountCreditorXML()));
		a.setModelApproval(xml.getModelApproval());
		a.setReferenceNumberCreditor(xml.getReferenceNumberCreditor());

		return a;
	}

}
