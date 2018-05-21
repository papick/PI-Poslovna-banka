package poslovna_banka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.City;
import poslovna_banka.model.Country;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.service.dto.CityDTO;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	public City addCity(CityDTO cityDTO) {

		City city = new City();
		city.setCode(cityDTO.getCode());
		city.setName(cityDTO.getName());
		Country country = countryRepository.findOneByName(cityDTO.getCountry());
		city.setCountry(country);
		city.setPostNum(cityDTO.getPostNum());

		return cityRepository.save(city);
	}

	public City editCity(Long id, CityDTO cityDTO) {

		City city = cityRepository.findOne(id);

		city.setName(cityDTO.getName());
		city.setCode(cityDTO.getCode());
		Country country = countryRepository.findOneByName(cityDTO.getCountry());
		city.setCountry(country);
		city.setPostNum(cityDTO.getPostNum());

		cityRepository.save(city);

		return null;

	}

	public City delete(Long id) {

		City city = cityRepository.findOne(id);
		if (city == null) {
			throw new IllegalArgumentException("Tried to delete" + "non-existant country");
		}
		cityRepository.delete(city);
		return city;
	}

}
