package poslovna_banka.resource;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import poslovna_banka.GeneratePdfReport;
import poslovna_banka.model.Currency;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.resource.response.ResponseCurrencies;
import poslovna_banka.service.CurrencyService;
import poslovna_banka.service.dto.CurrencyDTO;

@RestController
@RequestMapping(value = "/api/currency")
public class CurrencyResource {

	@Autowired
	private CurrencyRepository currRepo;
	
	@Autowired
	private CurrencyService currencyService;
	
	
	@GetMapping("/currency/{id}")
	public ResponseEntity<Currency> getCurrency(@PathVariable Long id) {
		
		Currency currency = currencyService.getCurrency(id);
		
		return new ResponseEntity<Currency>(currency,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getCountriesPdf() throws IOException, JRException {

		ArrayList<Currency> currencies = (ArrayList<Currency>) currencyService.getCurrencies();

        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(currencies);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	return ResponseEntity
            .ok()
            .headers(headers)
            .contentType(MediaType.APPLICATION_PDF)
            .body(new InputStreamResource(bis));
}
	
	
	@GetMapping("/get-currencies") // izmeniti
	public ResponseEntity<ResponseCurrencies> getCurrencies() throws FileNotFoundException, JRException, SQLException {

		ArrayList<Currency> currencies = (ArrayList<Currency>) currencyService.getCurrencies();

		return new ResponseEntity<>(new ResponseCurrencies(currencies), HttpStatus.OK);
	}
	
	
	@PostMapping("/add-currency")
	public ResponseEntity<Currency> addNewCurrency(@RequestBody CurrencyDTO currencyDTO) {
		
		Currency currency = currencyService.addNewCurrency(currencyDTO);
		
		return new ResponseEntity<Currency>(currency,HttpStatus.OK);	
		
	}
	
	
	@DeleteMapping("/delete-currency/{id}") 
	public ResponseEntity<Currency> deleteCurrency(@PathVariable Long id) {
		
		Currency currency = currencyService.deleteCurrency(id);
		
		return new ResponseEntity<Currency>(currency, HttpStatus.OK);
	}
	
	
	@PutMapping("/update-currency/{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody CurrencyDTO currencyEditDTO) {
		
		Currency currency = currencyService.editCurrency(id, currencyEditDTO);
		
		return new ResponseEntity<Currency>(currency,HttpStatus.OK);
	}
	
	
	
}