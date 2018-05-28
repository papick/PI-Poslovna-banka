package poslovna_banka.resource;

import java.util.ArrayList;
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

import poslovna_banka.model.Currency;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.service.dto.CurrencyDTO;

@RestController
@RequestMapping(value = "/api/currency")
public class CurrencyResource {

	@Autowired
	private CurrencyRepository currRepo;
	
	@GetMapping("/get-currency")
	public ResponseEntity<List<Currency>> getCurrencies() {

		ArrayList<Currency> currencies = (ArrayList<Currency>) currRepo.findAll();

		return new ResponseEntity<List<Currency>>(currencies, HttpStatus.OK);
	}
	
	@PostMapping("/new-currency/{countryId}")
	public ResponseEntity<Currency> addNewCurrency(@RequestBody CurrencyDTO currencyDTO, @PathVariable Long countryId) {
		
		
		
		return null;
		
	}
	
}
