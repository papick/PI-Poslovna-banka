package poslovna_banka.service;

import org.springframework.stereotype.Service;

import poslovna_banka.model.Currency;
import poslovna_banka.service.dto.CurrencyDTO;

@Service
public interface CurrencyService {

	public Currency findByName(String name);
	
	public Currency addNewCurrency(CurrencyDTO currencyDTO, Long countryId);
}
