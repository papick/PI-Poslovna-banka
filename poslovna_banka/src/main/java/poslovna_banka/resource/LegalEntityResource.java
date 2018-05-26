package poslovna_banka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		LegalEntity newLE=new LegalEntity();
		
		newLE.setName(le.getName());
		newLE.setAbbreviatedName(le.getAbbreviatedName());
		newLE.setAdress(le.getAdress());
		newLE.setDeliveringAdress(le.getDeliveringAdress());
		newLE.setEmail(le.getEmail());
		newLE.setJmbg(le.getJmbg());
		newLE.setMailReport(le.isMailReport());
		newLE.setMbr(le.getMbr());
		newLE.setPhoneNumber(le.getPhoneNumber());
		newLE.setPib(le.getPib());
		newLE.setResponsiblePerson(le.getResponsiblePerson());
		newLE.setTaxAuthority(le.getTaxAuthority());
		newLE.setActivity(activityRepo.findByCode(le.getActivity()));
		
		return new ResponseEntity<LegalEntity>(les.addLegalEntity(newLE), HttpStatus.OK);
	}
}
