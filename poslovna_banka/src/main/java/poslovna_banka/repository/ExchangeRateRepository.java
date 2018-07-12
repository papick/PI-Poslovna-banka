package poslovna_banka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Bank;
import poslovna_banka.model.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
	
	List<ExchangeRate> findAllByBank(Bank bank);
	
	
}
