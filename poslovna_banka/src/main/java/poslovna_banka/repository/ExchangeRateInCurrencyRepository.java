package poslovna_banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.ExchangeRateInCurrency;

@Repository
public interface ExchangeRateInCurrencyRepository extends JpaRepository<ExchangeRateInCurrency,Long>{
  
	// test
}
