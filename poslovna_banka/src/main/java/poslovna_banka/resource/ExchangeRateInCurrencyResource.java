package poslovna_banka.resource;

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

import poslovna_banka.model.ExchangeRateInCurrency;
import poslovna_banka.service.ExchangeRateInCurrencyService;
import poslovna_banka.service.dto.ExchangeRateInCurrencyDTO;

@RestController
@RequestMapping(value = "/api/exchange-rate-in-currency")
public class ExchangeRateInCurrencyResource {

	
	@Autowired
	private ExchangeRateInCurrencyService exchangeRateInCurrencyService;
	
	
	@PostMapping("/new-exchange-rate-in-currency")
	public ResponseEntity<ExchangeRateInCurrency> newExchangeRateInCurrency(@RequestBody ExchangeRateInCurrencyDTO exchangeRateInCurrencyDTO) {
		
		ExchangeRateInCurrency exchangeRateInCurrency = exchangeRateInCurrencyService.newExchangeRateInCurrency(exchangeRateInCurrencyDTO);
		
		return new ResponseEntity<ExchangeRateInCurrency>(exchangeRateInCurrency,HttpStatus.OK);
	}
	
	
	@GetMapping("/get-all/{id}")
	public ResponseEntity<List<ExchangeRateInCurrency>> getExchangeRatesInCurrency(@PathVariable Long id) {
		
		List<ExchangeRateInCurrency> exchangeRatesInCurrency = exchangeRateInCurrencyService.getExchangeRatesInCurrency(id);
		
		return new ResponseEntity<List<ExchangeRateInCurrency>>(exchangeRatesInCurrency,HttpStatus.OK);
		
	}
}
