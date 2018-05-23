package poslovna_banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
	
	//test

}
