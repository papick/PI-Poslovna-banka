package poslovna_banka.resource;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.service.AnalyticsOfStatementService;

@RestController
@RequestMapping(value = "/api/analytic")
public class AnalyticsOfStatementResource {

	@Autowired
	private AnalyticsOfStatementService analyticService;

	@GetMapping("/xml/{fileName}")
	public AnalyticOfStatement loadXML(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		System.out.println("aaaa" + fileName);
		return analyticService.getAnalyticsOfStatements(file);
	}
	
	@GetMapping("xml-naplata/{fileName}")
	public AnalyticOfStatement loadXMLPayment(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.getPaymentAnalyticsOfStatements(file);
	}
	
	@GetMapping("xml-prenos/{fileName}")
	public AnalyticOfStatement loadXMLTransfer(@PathVariable String fileName) throws JAXBException {
		File file = new File("nalozi\\" + fileName + ".xml");
		return analyticService.getPaymentAnalyticsOfStatements(file);
	}
}
