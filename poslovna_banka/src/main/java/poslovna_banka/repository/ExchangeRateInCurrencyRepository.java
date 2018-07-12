package poslovna_banka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.ExchangeRate;
import poslovna_banka.model.ExchangeRateInCurrency;

@Repository
public interface ExchangeRateInCurrencyRepository extends JpaRepository<ExchangeRateInCurrency,Long>{
  
	List<ExchangeRateInCurrency> findByExchangeRate(ExchangeRate exchangeRate);
}
