package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

	Currency findOneByName(String name);

	Currency findOneByOfficialCode(String officialCode);
}
