package poslovna_banka.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poslovna_banka.model.City;
import poslovna_banka.model.Country;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.service.dto.CountryDTO;

@Transactional
@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	public Country addCountry(CountryDTO countryDTO) {

		Country country = new Country();

		country.setCode(countryDTO.getCode());
		country.setName(countryDTO.getName());

		countryRepository.save(country);

		return country;

	}

	public Country editCountry(Long id, CountryDTO countryDTO) {

		Country country = countryRepository.findOne(id);

		country.setCode(countryDTO.getCode());
		country.setName(countryDTO.getName());

		countryRepository.save(country);

		return country;
	}

	public Country delete(Long id) {
		Country country = countryRepository.findOne(id);
		if (country == null) {
			throw new IllegalArgumentException("Tried to delete" + "non-existant country");
		}
		ArrayList<City> cities = cityRepository.findAllByCountry(country);
		cityRepository.delete(cities);
		countryRepository.delete(country);
		return country;
	}

}
