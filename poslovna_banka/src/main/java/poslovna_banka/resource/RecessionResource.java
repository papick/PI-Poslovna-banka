package poslovna_banka.resource;

import java.text.ParseException;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.BankAccount;
import poslovna_banka.model.Recession;
import poslovna_banka.service.AnalyticsOfStatementService;
import poslovna_banka.service.BankAccountService;
import poslovna_banka.service.RecessionService;

@RestController
@RequestMapping(value = "/api/recession")
public class RecessionResource {
	
	@Autowired
	private RecessionService recessionService;
	
	@Autowired
	private BankAccountService accountService;
	
	@Autowired
	private AnalyticsOfStatementService analyticService;
	
	@PostMapping()
	public ResponseEntity<Void> addRecession(@RequestBody Recession recession) throws JAXBException, ParseException {
		Recession newRecesion = recessionService.addRecession(recession);
	
		AnalyticOfStatement a = new AnalyticOfStatement();

		a.setDateOfReceipt(newRecesion.getDateOfRecession());
		a.setCurrencyDate(newRecesion.getDateOfRecession());
		a.setType("Nalog za prenos");
		if(newRecesion.getAccountFrom().getIndividual() == null) {
			a.setDebtor(newRecesion.getAccountFrom().getLegalEntity().getName());
		}else {
			a.setDebtor(newRecesion.getAccountFrom().getIndividual().getName());
		}
		a.setPurposeOfPayment("Ukidanje racuna");
		if(newRecesion.getAccountTo().getIndividual() == null) {
			a.setCreditor(newRecesion.getAccountTo().getLegalEntity().getName());

		}else {
			a.setCreditor(newRecesion.getAccountTo().getIndividual().getName());
		}
		a.setSum(1000.00);//otkud mi pare
		a.setDebtorAccount(newRecesion.getAccountFrom());
		a.setPaymentCurrency(newRecesion.getAccountFrom().getCurrency());
		a.setModelAssigments(97); // ne znam
		a.setReferenceNumberAssigments("BOP");//ne znam
		a.setAccountCreditor(newRecesion.getAccountTo());
		a.setModelApproval(97);//ne znam
		a.setReferenceNumberCreditor("BOP"); //ne znam
		a.setTypeOfMistake(0);// ne znam
		a.setStatus("1");//ne znam
		a.setCode("248");//ne znam
		a.setEmergency(false);	
		
		analyticService.saveAnalyticsOfStatementsTransfer(a);
		
		Long deletId =recession.getAccountFrom().getId();
		accountService.cancelAccount(deletId);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
