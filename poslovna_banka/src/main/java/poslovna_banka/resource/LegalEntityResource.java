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
import poslovna_banka.model.LegalEntity;
import poslovna_banka.repository.ActivityRepository;
import poslovna_banka.service.LegalEntityService;
import poslovna_banka.service.dto.LegalEntityDTO;

@RestController
@RequestMapping(value = "/api/legal-entity")
public class LegalEntityResource {

	@Autowired
	private LegalEntityService les;
	
	@Autowired
	private ActivityRepository activityRepo;
	
	@PostMapping("/add-legal-entity")
	public ResponseEntity<LegalEntity> addLegal(@RequestBody LegalEntityDTO le) {
		System.out.println("kristinaaaa");
		LegalEntity newLE=new LegalEntity();
		
		newLE.setName(le.getName());
		newLE.setAbbreviatedName(le.getAbbreviatedName());
		newLE.setAdress(le.getAdress());
		newLE.setDeliveringAdress(le.getDeliveringAdress());
		newLE.setEmail(le.getEmail());
		newLE.setJmbg(le.getJmbg());
		newLE.setMbr(le.getMbr());
		newLE.setPhoneNumber(le.getPhoneNumber());
		newLE.setPib(le.getPib());
		newLE.setResponsiblePerson(le.getResponsiblePerson());
		newLE.setTaxAuthority(le.getTaxAuthority());
		newLE.setActivity(activityRepo.findByCode(le.getActivity()));
		
		return new ResponseEntity<LegalEntity>(les.addLegalEntity(newLE), HttpStatus.OK);
	}
	
	@GetMapping("/get-legalEntities")
	public ResponseEntity<List<LegalEntity>> getLegalEntities() {
		return new ResponseEntity<List<LegalEntity>>(les.getAllLegalEntities(), HttpStatus.OK);
	}
	
	@GetMapping("/get-legalEntity/{id}")
	public ResponseEntity<LegalEntity> getLegalEntity(@PathVariable Long id) {
		return new ResponseEntity<LegalEntity>(les.getLegalEntity(id), HttpStatus.OK);
	}
	
	@PutMapping("/edit-legalEntity/{id}")
	public ResponseEntity<LegalEntity> editLegalEntity(@PathVariable Long id,@RequestBody LegalEntityDTO le) {
		return new ResponseEntity<LegalEntity>(les.modifyLegalEntity(id, le), HttpStatus.OK);
	}
	
	@DeleteMapping("delete-legalEntity/{id}")
	public void deleteLegalEntity(@PathVariable Long id) {
		les.delete(id);
	}
}
