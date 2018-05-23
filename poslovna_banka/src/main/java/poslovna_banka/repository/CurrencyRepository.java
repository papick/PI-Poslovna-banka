package poslovna_banka.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {

	
	// test
}
