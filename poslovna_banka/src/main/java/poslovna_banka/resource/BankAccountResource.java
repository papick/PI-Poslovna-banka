package poslovna_banka.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.IndividualRepository;
import poslovna_banka.repository.LegalEntityRepository;
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
	private LegalEntityRepository legalRepo;
	
	@Autowired
	private IndividualRepository indRepo;
	
	@GetMapping("/get-legals/{id}")
	public ResponseEntity<List<BankAccount>> getLegals(@PathVariable Long id) {
		List<BankAccount> legalEntities=bas.getAllLegalEntities();
		List<BankAccount> list=new ArrayList<>();
		for(BankAccount wanted: legalEntities){
			if(wanted.getBank().getId()==id){
				list.add(wanted);
			}
		}
		return new ResponseEntity<List<BankAccount>>(list, HttpStatus.OK);
	}

	@GetMapping("/get-individuals/{id}")
	public ResponseEntity<List<BankAccount>> getIndividuals(@PathVariable Long id) {
		List<BankAccount> individualEntities=bas.getAllIndividuals();
		List<BankAccount> list=new ArrayList<>();
		System.out.println("AAAAAAAAA ID JE "+id);
		for(BankAccount wanted: individualEntities){
			if(wanted.getBank().getId()==id){
				
				list.add(wanted);
			}
		}

		return new ResponseEntity<List<BankAccount>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/add-account-legal")
	public ResponseEntity<BankAccount> addLegal(@RequestBody BankAccountDTO ba) {
		BankAccount account = new BankAccount();
		Date d = new Date();
		account.setBank(bankRepo.findOne(Long.parseLong(ba.getBank())));
		account.setCurrency(currRepo.findByName(ba.getCurrency()));
		account.setDateOfOpenning(d.toString());
		account.setIndividual(null);
		account.setMailReporting(ba.isMailReporting());
		
		account.setLegalEntity((legalRepo.findByName(  ba.getLegalEntity() ) ) );
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
		account.setIndividual(indRepo.findByName(ba.getIndividual()));
		account.setLegalEntity(null);
		account.setNumber(ba.getNumber());
		account.setValid(true);
		
		return new ResponseEntity<BankAccount>(bas.addBankAccount(account), HttpStatus.OK);
	}
	
	@GetMapping("/get-account/{id}")
	public ResponseEntity<BankAccount> getBankAccount(@PathVariable Long id) {
		return new ResponseEntity<BankAccount>(bas.getBankAccount(id), HttpStatus.OK);
	}
	
	@PutMapping("/edit-legal-account/{id}")
	public ResponseEntity<BankAccount> editLegalEntity(@PathVariable Long id,@RequestBody BankAccountDTO b) {
		return new ResponseEntity<BankAccount>(bas.modifyLegalBankAccount(b, id), HttpStatus.OK);
	}
	
	@PutMapping("/edit-individual-account/{id}")
	public ResponseEntity<BankAccount> editIndividualEntity(@PathVariable Long id,@RequestBody BankAccountDTO b) {
		return new ResponseEntity<BankAccount>(bas.modifyIndividualBankAccount(b, id), HttpStatus.OK);
	}
}
