package poslovna_banka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.BankAccount;
import poslovna_banka.model.Recession;
import poslovna_banka.service.BankAccountService;
import poslovna_banka.service.RecessionService;
import poslovna_banka.service.dto.BankAccountDTO;

@RestController
@RequestMapping(value = "/api/recession")
public class RecessionResource {
	
	@Autowired
	private RecessionService recessionService;
	
	@Autowired
	private BankAccountService accountService;
	
	@PostMapping()
	public ResponseEntity<Void> addRecession(@RequestBody Recession recession) {
		recessionService.addRecession(recession);
		Long deletId =recession.getAccountFrom().getId();
		accountService.cancelAccount(deletId);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
