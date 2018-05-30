package poslovna_banka;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import poslovna_banka.model.Activity;
import poslovna_banka.model.Bank;
import poslovna_banka.model.BankAccount;
import poslovna_banka.model.City;
import poslovna_banka.model.Country;
import poslovna_banka.model.Currency;
import poslovna_banka.model.Individual;
import poslovna_banka.model.LegalEntity;
import poslovna_banka.model.PaymentType;
import poslovna_banka.model.User;
import poslovna_banka.repository.ActivityRepository;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.repository.CityRepository;
import poslovna_banka.repository.CountryRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.IndividualRepository;
import poslovna_banka.repository.LegalEntityRepository;
import poslovna_banka.repository.PaymentTypeRepository;
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

	@Autowired
	private ActivityRepository activitiesRepository;

	@Autowired
	private CurrencyRepository currRepo;

	@Autowired
	private LegalEntityRepository leRepo;

	@Autowired
	private IndividualRepository individualRepo;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

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

		Bank bank = new Bank("001", "111", "Erste banka", "Narodnog fronta 23", "erste@gmail.com", "www.erste.com",
				" 021 4809299", "1122");
		bankRepository.save(bank);

		Bank bank1 = new Bank("002", "222", "Banka Intesa", "Narodnog fronta 50", "intesa@gmail.com", "www.intesa.com",
				" 021 4809889", "3344");
		bankRepository.save(bank1);

		User user1 = new User("milica", "milica", bank);
		User user2 = new User("dejan", "dejan", bank);
		User user3 = new User("kristina", "kristina", bank1);
		userRepository.save(user3);
		userRepository.save(user1);
		userRepository.save(user2);

		Activity activity1 = new Activity("01", "Poljoprivredna proizvodnja,lov,pratece delatnosti");
		Activity activity2 = new Activity("01.11", "Gajenje zita");
		Activity activity4 = new Activity("01.2", "Gajenje visegodisnjih biljaka");
		Activity activity3 = new Activity("01.21", "Gajenje grozdja");

		activitiesRepository.save(activity1);
		activitiesRepository.save(activity2);
		activitiesRepository.save(activity3);
		activitiesRepository.save(activity4);

		PaymentType paymentType = new PaymentType("1", "gotovinski");
		paymentTypeRepository.save(paymentType);

		Currency curr = new Currency("din", country1, "Dinar", true);
		currRepo.save(curr);
		Currency curr1 = new Currency("eur", country1, "Euro", true);
		currRepo.save(curr1);

		LegalEntity le = new LegalEntity("NN d.o.o", "as", "asdasd", "1234", "123124", "sdads", "1231", "poreska",
				"1231231", "asdad", true, activity1, "kristina");
		leRepo.save(le);

		LegalEntity zara = new LegalEntity("Zara", "aa", "aaaa", "1111", "111111", "ssss", "1122", "poreska", "1231231",
				"aaaa", true, activity1, "jelena");
		leRepo.save(zara);

		Individual i = new Individual("hbj", "k", "uyhg", "56", "6666666666666", "ujh", "hg", true);
		individualRepo.save(i);


		BankAccount bankAccount = new BankAccount("123456", "29-05-2018", true, bank, null, le, curr);
		bankAccountRepository.save(bankAccount);

		BankAccount bankAccount1 = new BankAccount("777888", bank, zara);
		bankAccountRepository.save(bankAccount1);




	}
}