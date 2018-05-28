package poslovna_banka.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.BankAccount;
import poslovna_banka.model.LegalEntity;
import poslovna_banka.repository.ActivityRepository;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.service.BankAccountService;
import poslovna_banka.service.dto.BankAccountDTO;

@RestController
@RequestMapping(value = "/api/bankAccounts")
public class BankAccountResource {
	
	@Autowired
	private BankAccountService bas;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Autowired
	private CurrencyRepository currRepo;
	
	@Autowired
	private ActivityRepository actRepo;
	
	@GetMapping("/get-legals")
	public ResponseEntity<List<BankAccount>> getLegals() {
		return new ResponseEntity<List<BankAccount>>(bas.getAllLegalEntities(), HttpStatus.OK);
	}

	@GetMapping("/get-individuals")
	public ResponseEntity<List<BankAccount>> getIndividuals() {
		return new ResponseEntity<List<BankAccount>>(bas.getAllIndividuals(), HttpStatus.OK);
	}
	
	@PostMapping("/add-account-legal")
	public ResponseEntity<BankAccount> addLegal(@RequestBody BankAccountDTO ba) {
		BankAccount account = new BankAccount();
		Date d = new Date();
		account.setBank(bankRepo.findOne(Long.parseLong(ba.getBank())));
		account.setCurrency(currRepo.findByName(ba.getCurrency()));
		account.setDateOfOpenning(d.toString());
		account.setIndividual(null);
		
		LegalEntity legalEntity=new LegalEntity();
		legalEntity.setName(ba.getLegalEntity().getName());
		legalEntity.setAbbreviatedName(ba.getLegalEntity().getAbbreviatedName());
		legalEntity.setActivity(actRepo.findByCode((ba.getLegalEntity().getActivity())));
		legalEntity.setAdress(ba.getLegalEntity().getAdress());
		legalEntity.setDeliveringAdress(ba.getLegalEntity().getDeliveringAdress());
		legalEntity.setEmail(ba.getLegalEntity().getEmail());
		legalEntity.setJmbg(ba.getLegalEntity().getJmbg());
		legalEntity.setMailReport(ba.getLegalEntity().isMailReport());
		legalEntity.setMbr(ba.getLegalEntity().getMbr());
		legalEntity.setPhoneNumber(ba.getLegalEntity().getPhoneNumber());
		legalEntity.setPib(ba.getLegalEntity().getPib());
		legalEntity.setResponsiblePerson(ba.getLegalEntity().getResponsiblePerson());
		legalEntity.setTaxAuthority(ba.getLegalEntity().getTaxAuthority());
		
		account.setLegalEntity(legalEntity);
		account.setNumber(ba.getNumber());
		account.setValid(true);
		
		return new ResponseEntity<BankAccount>(bas.addBankAccount(account), HttpStatus.OK);
	}
	
	@PostMapping("/add-account-individual")
	public ResponseEntity<BankAccount> addIndividual(@RequestBody BankAccountDTO ba) {
		BankAccount account = new BankAccount();
		Date d = new Date();
		account.setBank(bankRepo.findOne(Long.parseLong(ba.getBank())));
		account.setCurrency(currRepo.findByName(ba.getCurrency()));
		account.setDateOfOpenning(d.toString());
		account.setIndividual(ba.getIndividual());
		account.setLegalEntity(null);
		account.setNumber(ba.getNumber());
		account.setValid(true);
		System.out.println(account.toString());
		
		return new ResponseEntity<BankAccount>(bas.addBankAccount(account), HttpStatus.OK);
	}
}
