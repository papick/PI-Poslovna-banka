package poslovna_banka.resource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import net.sf.jasperreports.engine.JRException;
import poslovna_banka.GeneratePdfReport;
import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.AnalyticOfStatementRepository;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.service.ReportsService;
import poslovna_banka.service.dto.ReportDTO;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/reports")
public class ReportsResource {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private ReportsService reportsService;
	
	@Autowired
	private AnalyticOfStatementRepository analyticRepo;
	
	@Autowired
	private BankAccountRepository accRepo;
	
	@RequestMapping(value = "/get-accounts/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getCountriesPdf(@PathVariable Long id) throws IOException, JRException {
		
		
		
		
		ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) reportsService.getBankAccountsByBank(id);
		
		String bankName = bankRepository.findOne(id).getName();

        ByteArrayInputStream bis = GeneratePdfReport.accountsReport(accounts,bankName);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
        headers.setContentType(MediaType.APPLICATION_PDF);
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

		
	}
	
	
	@RequestMapping(value="/get-client-report", method=RequestMethod.POST,
			produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> clientReport(@RequestBody ReportDTO rep) throws ParseException, TransformerException {
		List<AnalyticOfStatement> analyticsCred = new ArrayList<AnalyticOfStatement>();
		List<AnalyticOfStatement> analyticsDebt = new ArrayList<AnalyticOfStatement>();
		List<AnalyticOfStatement> analytics = new ArrayList<AnalyticOfStatement>();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	    
	    
		
		analyticsCred = analyticRepo.findAllByAccountCreditor(accRepo.findOneByNumber(rep.getBankAccount()));
		analyticsDebt = analyticRepo.findAllByDebtorAccount(accRepo.findOneByNumber(rep.getBankAccount()));
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date from = format.parse(rep.getFrom());
		Date to = format.parse(rep.getTo());
		
		for(AnalyticOfStatement a : analyticsCred) {
			Date receipt = format.parse(a.getDateOfReceipt());
			System.out.println(receipt.toString());
			if( receipt.after(from) && receipt.before(to)) {
				analytics.add(a);
			}
		}
		
		for(AnalyticOfStatement a : analyticsDebt) {
			Date receipt = format.parse(a.getDateOfReceipt());
			System.out.println(receipt.toString());
			if( receipt.after(from) && receipt.before(to)) {
				analytics.add(a);
			}
		}
		
		double initial;
		AnalyticOfStatement a = analytics.get(0);
		Date minDate = format.parse(a.getDateOfReceipt());
		for(int i = 1; i < analytics.size(); ++i) {
			Date receipt = format.parse(analytics.get(i).getDateOfReceipt());		
			if(receipt.before(minDate)){
				a = analytics.get(i);
				minDate = format.parse(a.getDateOfReceipt());
			}
		}
		initial = a.getDailyAccountState().getPreviousState();
		
		double endState;
		AnalyticOfStatement ma = analytics.get(0);
		Date maxDate = format.parse(ma.getDateOfReceipt());
		for(int i = 1; i < analytics.size(); ++i) {
			Date receipt = format.parse(analytics.get(i).getDateOfReceipt());		
			if(receipt.after(maxDate)){
				ma = analytics.get(i);
				minDate = format.parse(ma.getDateOfReceipt());
			}
		}
		endState = ma.getDailyAccountState().getNewState();
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement =
	             doc.createElementNS("https://www.journaldev.com/employee", "Report");
			doc.appendChild(rootElement);
			
			Element e = doc.createElement("initialState");
			e.appendChild(doc.createTextNode(String.valueOf(initial)));
			rootElement.appendChild(e);
			
			Element e1 = doc.createElement("endState");
			e1.appendChild(doc.createTextNode(String.valueOf(endState)));
			rootElement.appendChild(e1);
			
			Element e2 = doc.createElement("client");
			if(accRepo.findOneByNumber(rep.getBankAccount()).getIndividual() != null)
				e2.appendChild(doc.createTextNode(accRepo.findOneByNumber(rep.getBankAccount()).getIndividual().getName()));
			else
				e2.appendChild(doc.createTextNode(accRepo.findOneByNumber(rep.getBankAccount()).getLegalEntity().getName()));
			rootElement.appendChild(e2);
			
			Element e3 = doc.createElement("analytics");
			for(AnalyticOfStatement an : analytics) {
				Element temp = doc.createElement("analytic");
				Element sum = doc.createElement("sum");
				Element type = doc.createElement("type");
				sum.appendChild(doc.createTextNode(String.valueOf(an.getSum())));
				type.appendChild(doc.createTextNode(an.getType()));
				temp.appendChild(sum);
				temp.appendChild(type);
				e3.appendChild(temp);
			}
			
			rootElement.appendChild(e3);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
			
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("C:/Users/Korisnik/Desktop/Nikola/" + accRepo.findOneByNumber(rep.getBankAccount()).getNumber() + ".xml"));
			
			transformer.transform(source, console);
			transformer.transform(source, file);
			
			System.out.println("DONE");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
        ByteArrayInputStream bis = GeneratePdfReport.clientReport(accRepo.findOneByNumber(rep.getBankAccount()), analytics, initial, endState);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

	}

}
