package poslovna_banka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poslovna_banka.model.Individual;
import poslovna_banka.service.IndividualService;

@RestController
@RequestMapping(value = "/api/individual")
public class IndividualResource {

	@Autowired
	private IndividualService is;
	
	@PostMapping("/add-individual")
	public ResponseEntity<Individual> addLegal(@RequestBody Individual i) {
		return new ResponseEntity<Individual>(is.addIndividual(i), HttpStatus.OK);
	}
}
