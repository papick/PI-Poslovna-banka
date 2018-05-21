package poslovna_banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	Country findOneByName(String name);
}
