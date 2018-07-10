package poslovna_banka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Country;
import poslovna_banka.model.Currency;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.service.dto.CurrencyDTO;
import poslovna_banka.service.dto.CurrencyEditDTO;

@Service
public class CurrencyService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	
	public List<Currency> getCurrencies() {
		
		List<Currency> currencies = (List<Currency>) currencyRepository.findAll();
		
		return currencies;
	}
	
	
	public Currency getCurrency(Long id) {
		
		Currency currency = currencyRepository.findOne(id);
		
		return currency;
	}
	
	
	public Currency addNewCurrency(CurrencyDTO currencyDTO) {
			
		
		Currency currency = new Currency();
		
		currency.setOfficialCode(currencyDTO.getOfficialCode());
		currency.setName(currencyDTO.getName());
		
		if(currencyDTO.getDomicilna()==null) {
			currency.setDomicilna(false);
		}else{
			currency.setDomicilna(true);
		}	
		
		Country country = countryRepository.findOneByName(currencyDTO.getCountryName());
		currency.setCountry(country);
		
		currencyRepository.save(currency);
		
		return currency;
		
	}
	
	
	public Currency deleteCurrency(Long currencyId) {
		
		Currency currency = currencyRepository.findOne(currencyId);
		currencyRepository.delete(currency);
		
		// add connections to other tables
		
		return currency;
	}
	
	
	public Currency editCurrency(Long currencyId, CurrencyDTO currencyEditDTO) {
		
		Currency currency = currencyRepository.findOne(currencyId);
		
		currency.setName(currencyEditDTO.getName());
		currency.setOfficialCode(currencyEditDTO.getOfficialCode());
		currency.setDomicilna(currencyEditDTO.getDomicilna());
		
		Country country = countryRepository.findOneByName(currencyEditDTO.getCountryName());
		currency.setCountry(country);
		
		currencyRepository.save(currency);
			
		return currency;
		
	}
	
	
}
