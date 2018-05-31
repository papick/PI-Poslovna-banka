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
import poslovna_banka.model.Individual;
import poslovna_banka.service.IndividualService;

@RestController
@RequestMapping(value = "/api/individual")
public class IndividualResource {

	@Autowired
	private IndividualService is;
	
	@PostMapping("/add-individual")
	public ResponseEntity<Individual> addIndividual(@RequestBody Individual i) {
		
		Individual individualForAdd=is.addIndividual(i);
		return new ResponseEntity<Individual>(individualForAdd, HttpStatus.OK);
	}
	
	@GetMapping("/get-individualEntities")
	public ResponseEntity<List<Individual>> getIndividualEntities() {
		return new ResponseEntity<List<Individual>>(is.getAllIndividuals(), HttpStatus.OK);
	}
}
