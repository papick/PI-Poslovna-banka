package poslovna_banka;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import poslovna_banka.model.Bank;
import poslovna_banka.model.City;
import poslovna_banka.model.Country;
import poslovna_banka.model.User;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.repository.UserRepository;

@Component
public class TestData {

	@Autowired
	private CountryRepository countryService;

	@Autowired
	private CityRepository cityService;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void init() {

		Country country1 = new Country("Serbia", "SRB");
		countryService.save(country1);

		Country country2 = new Country("Belgium", "BEL");
		countryService.save(country2);

		Country country3 = new Country("Portugal", "POR");
		countryService.save(country3);

		Country country4 = new Country("Estonia", "EST");
		countryService.save(country4);

		Country country5 = new Country("Lithuania", "LIT");
		countryService.save(country5);

		City city1 = new City("Novi Sad", country1, "NS", "21000");
		cityService.save(city1);

		City city2 = new City("Beograd", country1, "BG", "11000");
		cityService.save(city2);

		City city3 = new City("Nis", country1, "NI", "18000");
		cityService.save(city3);
		
		Bank bank = new Bank("001","111","Erste banka","Narodnog fronta 23","erste@gmail.com","www.erste.com"," 021 4809299","1122");
		bankRepository.save(bank);
		
		Bank bank1 = new Bank("002","222","Banka Intesa","Narodnog fronta 50","intesa@gmail.com","www.intesa.com"," 021 4809889","3344");
		bankRepository.save(bank1);
		
		User user1 = new User("milica","milica",bank);
		User user2 = new User("dejan","dejan",bank);
		User user3 = new User("kristina","kristina",bank1);
		userRepository.save(user3);
		userRepository.save(user1);
		userRepository.save(user2);
	}
}