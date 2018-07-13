package poslovna_banka.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

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

import net.sf.jasperreports.engine.JRException;
import poslovna_banka.GeneratePdfReport;
import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.service.ReportsService;
import poslovna_banka.service.dto.ReportDTO;

@RestController
@RequestMapping(value = "/api/reports")
public class ReportsResource {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private ReportsService reportsService;
	
	@RequestMapping(value = "/get-accounts/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getCountriesPdf(@PathVariable Long id) throws IOException, JRException {
		
		
		
		
		ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) reportsService.getBankAccountsByBank(id);
		
		String bankName = bankRepository.findOne(id).getName();

        ByteArrayInputStream bis = GeneratePdfReport.accountsReport(accounts,bankName);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

		
	}
	
	
	@RequestMapping(value="/get-client-report", method=RequestMethod.POST,
			produces = MediaType.APPLICATION_PDF_VALUE)
	public void clientReport(@RequestBody ReportDTO rep) {
		/*ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) reportsService.getBankAccountsByBank(id);

        ByteArrayInputStream bis = GeneratePdfReport.accountsReport(accounts,bankName);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));*/
		System.out.println("bank account: " + rep.getBankAccount());
		System.out.println("from: " + rep.getFrom());
		System.out.println("to: " + rep.getTo());
		//return new ResponseEntity<void>(HttpStatus.OK);

	}

}
