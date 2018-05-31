package poslovna_banka.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.City;
import poslovna_banka.model.Country;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	ArrayList<City> findAllByCountry(Country country);

	City findOneByName(String name);

}
