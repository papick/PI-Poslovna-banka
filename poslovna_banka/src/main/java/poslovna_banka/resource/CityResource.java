package poslovna_banka.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.City;
import poslovna_banka.model.Country;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.resource.response.ResponseCities;
import poslovna_banka.service.CityService;
import poslovna_banka.service.dto.CityDTO;

@RestController
@RequestMapping(value = "/api/cities")
public class CityResource {

	@Autowired
	private CityService cityService;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("/get-all-cities")
	public ResponseEntity<ResponseCities> getCities() {

		ArrayList<City> cities = (ArrayList<City>) cityRepository.findAll();

		return new ResponseEntity<>(new ResponseCities(cities), HttpStatus.OK);
	}

	@GetMapping("/get-by-country/{id}")
	public ResponseEntity<ResponseCities> getCities(@PathVariable Long id) {

		Country country = countryRepository.findOne(id);
		ArrayList<City> cities = cityRepository.findAllByCountry(country);

		return new ResponseEntity<>(new ResponseCities(cities), HttpStatus.OK);
	}

	@GetMapping("/get-city/{id}")
	public ResponseEntity<City> getCity(@PathVariable Long id) {

		City city = cityRepository.findOne(id);
		if (city == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	@PostMapping("/add-city")
	public ResponseEntity<City> addCity(@RequestBody CityDTO cityDTO) {

		City city = cityService.addCity(cityDTO);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}

	@DeleteMapping("/delete-city/{id}")
	public ResponseEntity<City> deleteCity(@PathVariable Long id) {

		City city = cityService.delete(id);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	@PutMapping("/edit-city/{id}")
	public ResponseEntity<City> editCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {

		City city = cityService.editCity(id, cityDTO);
		return new ResponseEntity<>(city, HttpStatus.OK);

	}

}
