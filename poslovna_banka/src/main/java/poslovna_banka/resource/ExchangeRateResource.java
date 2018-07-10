package poslovna_banka.resource;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.ExchangeRate;
import poslovna_banka.service.ExchangeRateService;
import poslovna_banka.service.dto.ExchangeRateDTO;

@RestController
@RequestMapping(value = "/api/exchange-rate")
public class ExchangeRateResource {

	
	@Autowired
	ExchangeRateService exchangeRateService;
	
	
	@GetMapping("/get-exchange-rates/{id}")
	public ResponseEntity<List<ExchangeRate>> getExchangeRates(@PathVariable Long id) {
		
		List<ExchangeRate> exchangeRates = exchangeRateService.getAllExchangeRatesByBank(id);
		
		return new ResponseEntity<List<ExchangeRate>>(exchangeRates,HttpStatus.OK);
	}
	
	
	@PostMapping("/new-exchange-rate")
	public ResponseEntity<ExchangeRate> newExchangeRate(@RequestBody ExchangeRateDTO exchangeRateDTO) throws ParseException {
		
		ExchangeRate exchangeRate = exchangeRateService.newExchangeRate(exchangeRateDTO);
	
		return new ResponseEntity<ExchangeRate>(exchangeRate,HttpStatus.OK);
	}
	
	
	
	
}
