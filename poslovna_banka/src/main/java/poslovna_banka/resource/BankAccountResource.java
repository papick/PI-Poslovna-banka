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
import poslovna_banka.service.BankAccountService;

@RestController
@RequestMapping(value = "/api/bankAccounts")
public class BankAccountResource {
	
	@Autowired
	private BankAccountService bas;
	
	@GetMapping("/get-legals")
	public ResponseEntity<List<BankAccount>> getLegals() {
		return new ResponseEntity<List<BankAccount>>(bas.getAllLegalEntities(), HttpStatus.OK);
	}

	@GetMapping("/get-individuals")
	public ResponseEntity<List<BankAccount>> getIndividuals() {
		return new ResponseEntity<List<BankAccount>>(bas.getAllIndividuals(), HttpStatus.OK);
	}
	
	@PostMapping("/add-legal")
	public ResponseEntity<BankAccount> addLegal(@RequestBody BankAccount ba) {
		return new ResponseEntity<BankAccount>(bas.addBankAccount(ba), HttpStatus.OK);
	}
}
