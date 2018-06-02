package poslovna_banka.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poslovna_banka.model.Individual;
import poslovna_banka.model.LegalEntity;
import poslovna_banka.service.IndividualService;
import poslovna_banka.service.dto.LegalEntityDTO;

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
	
	@DeleteMapping("/delete-individualEntities/{id}")
	public void deleteIndv(@PathVariable Long id) {
		is.delete(id);
	}
	
	@GetMapping("/get-individual/{id}")
	public ResponseEntity<Individual> getIndividual(@PathVariable Long id) {
		return new ResponseEntity<Individual>(is.get(id), HttpStatus.OK);
	}
	
	@PutMapping("/edit-individual/{id}")
	public ResponseEntity<Individual> editIndividual(@PathVariable Long id,@RequestBody Individual i) {
		return new ResponseEntity<Individual>(is.modifyIndividual(i, id), HttpStatus.OK);
	}
}
