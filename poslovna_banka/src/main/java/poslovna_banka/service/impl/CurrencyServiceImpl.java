package poslovna_banka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Currency;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService{

	@Autowired
	private CurrencyRepository currRepo;
	
	@Override
	public Currency findByName(String name) {
		Currency curr = currRepo.findByName(name);
		return curr;
	}

}
