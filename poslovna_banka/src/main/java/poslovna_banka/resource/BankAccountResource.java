package poslovna_banka.resource;

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
	
	@GetMapping("/get-legals")
	public ResponseEntity<List<BankAccount>> getLegals() {
		return new ResponseEntity<List<BankAccount>>(bas.getAllLegalEntities(), HttpStatus.OK);
	}

	@GetMapping("/get-individuals")
	public ResponseEntity<List<BankAccount>> getIndividuals() {
		return new ResponseEntity<List<BankAccount>>(bas.getAllIndividuals(), HttpStatus.OK);
	}
	
	/*@PostMapping("/add-account-legal")
	public ResponseEntity<BankAccount> addLegal(@RequestBody BankAccountDTO ba) {
		BankAccount account = new BankAccount();
		account.setBank(bankRepo.findOne(Long.parseLong(ba.getBank())));
		account.setCurrency(currRepo.findByName(ba.getCurrency()));
		account.setDateOfOpenning(ba.getDateOfOpenning());
		account.setIndividual(null);
		account.setLegalEntity(ba.getLegalEntity());
		
		return new ResponseEntity<BankAccount>(bas.addBankAccount(ba), HttpStatus.OK);
	}*/
}
