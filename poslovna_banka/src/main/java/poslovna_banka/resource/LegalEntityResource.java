package poslovna_banka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poslovna_banka.model.LegalEntity;
import poslovna_banka.service.LegalEntityService;

@RestController
@RequestMapping(value = "/api/legal-entity")
public class LegalEntityResource {

	@Autowired
	private LegalEntityService les;
	
	@PostMapping("/add-legal-entity")
	public ResponseEntity<LegalEntity> addLegal(@RequestBody LegalEntity le) {
		return new ResponseEntity<LegalEntity>(les.addLegalEntity(le), HttpStatus.OK);
	}
}
