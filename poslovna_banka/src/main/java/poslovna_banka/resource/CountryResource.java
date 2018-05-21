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

import poslovna_banka.model.Country;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.resource.response.ResponseCountries;
import poslovna_banka.service.CountryService;
import poslovna_banka.service.dto.CountryDTO;

@RestController
@RequestMapping(value = "/api/countries")
public class CountryResource {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryService countryService;

	@GetMapping("/get-countries")
	public ResponseEntity<ResponseCountries> getCountries() {

		ArrayList<Country> countries = (ArrayList<Country>) countryRepository.findAll();

		return new ResponseEntity<>(new ResponseCountries(countries), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Country country = countryRepository.findOne(id);
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(country, HttpStatus.OK);
	}

	@PostMapping("/add-country")
	public ResponseEntity<Country> addCountry(@RequestBody CountryDTO countryDTO) {

		Country newCountry = countryService.addCountry(countryDTO);
		return new ResponseEntity<Country>(newCountry, HttpStatus.OK);
	}

	@DeleteMapping("/delete-country/{id}")
	public ResponseEntity<Country> delete(@PathVariable Long id) {

		Country deleted = countryService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@PutMapping("/edit-country/{id}")
	public ResponseEntity<Country> editCity(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {

		Country country = countryService.editCountry(id, countryDTO);
		return new ResponseEntity<>(country, HttpStatus.OK);

	}

}
