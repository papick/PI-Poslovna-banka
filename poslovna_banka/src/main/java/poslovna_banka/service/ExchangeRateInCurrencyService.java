package poslovna_banka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Currency;
import poslovna_banka.model.ExchangeRate;
import poslovna_banka.model.ExchangeRateInCurrency;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.ExchangeRateInCurrencyRepository;
import poslovna_banka.repository.ExchangeRateRepository;
import poslovna_banka.service.dto.ExchangeRateInCurrencyDTO;

@Service
public class ExchangeRateInCurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private ExchangeRateInCurrencyRepository exchangeRateInCurrencyRepository;
	
	
	public ExchangeRateInCurrency newExchangeRateInCurrency(ExchangeRateInCurrencyDTO exchangeRateInCurrencyDTO) {
		
		ExchangeRateInCurrency exchRateInCurrency = new ExchangeRateInCurrency();
		
		ExchangeRate exchRate = exchangeRateRepository.findOne(exchangeRateInCurrencyDTO.getIdExchangeRate());
		Currency primaryCurrency = currencyRepository.findOneByName(exchangeRateInCurrencyDTO.getPrimaryCurrency());
		Currency toOtherCurrency = currencyRepository.findOneByName(exchangeRateInCurrencyDTO.getToOtherCurrency());
		
		exchRateInCurrency.setExchangeRate(exchRate);
		exchRateInCurrency.setPrimaryCurrency(primaryCurrency);
		exchRateInCurrency.setToOtherCurrency(toOtherCurrency);
		
		exchRateInCurrency.setBuying(exchangeRateInCurrencyDTO.getBuying());
		exchRateInCurrency.setSelling(exchangeRateInCurrencyDTO.getSell());
		exchRateInCurrency.setMiddle(exchangeRateInCurrencyDTO.getMiddle());
		
		exchangeRateInCurrencyRepository.save(exchRateInCurrency);
		
		return exchRateInCurrency;
	}
	
	
	
	public List<ExchangeRateInCurrency> getExchangeRatesInCurrency(Long id) {
		
		
		  ExchangeRate exchRate = exchangeRateRepository.findOne(id);
		  
		  List<ExchangeRateInCurrency> exchangeRatesInCurrency = exchangeRateInCurrencyRepository.findByExchangeRate(exchRate);
		
		
		return exchangeRatesInCurrency;
	}
	
	
	
}
