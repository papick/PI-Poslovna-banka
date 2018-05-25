package poslovna_banka.service;

import org.springframework.stereotype.Service;

import poslovna_banka.model.Currency;

@Service
public interface CurrencyService {

	public Currency findByName(String name);
}
