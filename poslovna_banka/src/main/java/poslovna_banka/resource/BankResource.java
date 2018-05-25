package poslovna_banka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poslovna_banka.model.Bank;
import poslovna_banka.repository.BankRepository;

@RestController
@RequestMapping(value = "/api/bank")
public class BankResource {

	
	@Autowired
	private BankRepository bankRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<Bank> getBank(@PathVariable Long id) {
		Bank bank = bankRepo.findOne(id);
		return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}
}
