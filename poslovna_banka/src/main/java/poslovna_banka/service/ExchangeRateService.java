package poslovna_banka.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Bank;
import poslovna_banka.model.ExchangeRate;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.repository.ExchangeRateInCurrencyRepository;
import poslovna_banka.repository.ExchangeRateRepository;
import poslovna_banka.service.dto.ExchangeRateDTO;

@Service
public class ExchangeRateService {
	

	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private ExchangeRateInCurrencyRepository exchangeRateInCurrencyRepository;
	
	
	public List<ExchangeRate> getAllExchangeRatesByBank(Long id) {
		
		List<ExchangeRate> exchangeRates = new ArrayList<ExchangeRate>();
		
		Bank bank = bankRepository.findOne(id);
		
		exchangeRates = exchangeRateRepository.findAllByBank(bank);
		
		return exchangeRates;
	}
	
	
	public ExchangeRate newExchangeRate(ExchangeRateDTO exchangeRateDTO) throws ParseException {
		
		ExchangeRate exchangeRate = new ExchangeRate();
		
		exchangeRate.setAppliedFromDate(exchangeRateDTO.getAppliedFrom());
		exchangeRate.setBank(bankRepository.findOne(exchangeRateDTO.getIdBank()));
		exchangeRate.setNumber(bankRepository.findAll().size()+1);
		
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
			
		exchangeRate.setDate(modifiedDate);
		
		exchangeRateRepository.save(exchangeRate);
				
		
		return exchangeRate;
	}

}
