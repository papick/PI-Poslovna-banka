package poslovna_banka.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.AnalyticOfStatementRepository;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.LegalEntityRepository;
import poslovna_banka.repository.PaymentTypeRepository;

@Service
public class AnalyticsOfStatementService {

	@Autowired
	private AnalyticOfStatementRepository analyticRepository;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private LegalEntityRepository legalEntityRepository;

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	public AnalyticOfStatement getAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(AnalyticOfStatement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalyticOfStatement xml = (AnalyticOfStatement) jaxbUnmarshaller.unmarshal(file);
		AnalyticOfStatement a = generateAnalyticsOfStatement(xml);
		analyticRepository.save(a);

		if (a.getType().equals("Nalog za isplatu")) {
			BankAccount debtorAccount = bankAccountRepository.findOne(a.getDebtorAccount().getId());
			// DailyAccountBalance dailyAccountBalance =
			// dailyAccountBalanceService.findByAccountNumberAndDate(debtorAccount,
			// a.getCurrencyDate());
			// dailyAccountBalance.setTrafficToTheBurden(dailyAccountBalance.getTrafficToTheBurden()
			// + a.getSum());
			// dailyAccountBalance.setNewState(dailyAccountBalance.getPreviousState()+
			// dailyAccountBalance.getTrafficToBenefit() -
			// dailyAccountBalance.getTrafficToTheBurden());
			// dailyAccountBalance.getAnalyticsOfStatements().add(a);
			// dailyAccountBalanceService.save(dailyAccountBalance);
		}

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
		System.out.println("aaaaaa  " + paymentTypeRepository.findOneByCode(xml.getPaymentTypeXML()) +  currencyRepository.findOneByOfficialCode(xml.getPaymentCurrencyXML()));

		return a;
	}

}
