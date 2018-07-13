package poslovna_banka.resource;

import java.io.File;
import java.text.ParseException;

import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.Bank;
import poslovna_banka.service.AnalyticsOfStatementService;

@RestController
@RequestMapping(value = "/api/analytic")
public class AnalyticsOfStatementResource {

	@Autowired
	private AnalyticsOfStatementService analyticService;

	
	// nalog za uplatu ucitaj
	@GetMapping("/xml-order/{fileName}")
	public AnalyticOfStatement loadXMLOrder(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.getAnalyticsOfStatementsOrder(file);
	}
	
	
	@GetMapping("/save/xml-order/{fileName}")
	public AnalyticOfStatement saveAnalyticsOrder(@PathVariable String fileName) throws JAXBException, ParseException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.saveAnalyticsOfStatementsOrder(file);
	}
	
	
	// nalog za isplatu ucitaj
	@GetMapping("/xml/{fileName}")
	public AnalyticOfStatement loadXML(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.getAnalyticsOfStatements(file);
	}

	// nalog za isplatu sacuvaj
	@GetMapping("/save/xml/{fileName}")
	public AnalyticOfStatement saveAnalytics(@PathVariable String fileName) throws JAXBException, ParseException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.saveAnalyticsOfStatements(file);
	}
	
	// nalog za naplatu sacuvaj
	@GetMapping("/save/xml-payment/{fileName}")
	public AnalyticOfStatement saveAnalyticsPayment(@PathVariable String fileName) throws JAXBException, ParseException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.saveAnalyticsOfStatementsPayment(file);
	}
	//nalog za naplatu ucitaj
	@GetMapping("xml-naplata/{fileName}")
	public AnalyticOfStatement loadXMLPayment(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.getPaymentAnalyticsOfStatements(file);
	}

	//nalog za prenos ucitaj
	@GetMapping("xml-prenos/{fileName}")
	public AnalyticOfStatement loadXMLTransfer(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		AnalyticOfStatement analytic = analyticService.getPaymentAnalyticsOfStatements(file);
	
		return analytic;
	}
	
	// nalog za prenos sacuvaj
	@GetMapping("/save/xml-transfer/{fileName}")
	public AnalyticOfStatement saveAnalyticsTransfer(@PathVariable String fileName) throws JAXBException, ParseException {
		File file = new File("nalozi\\" + fileName + ".xml");
		AnalyticOfStatement analytic = analyticService.saveAnalyticsOfStatementsTransfer(file);
		analyticService.generateBankTransfer(analytic);
		return analytic;
	}
}
