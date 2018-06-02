package poslovna_banka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.LegalEntity;
import poslovna_banka.repository.ActivityRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.LegalEntityRepository;
import poslovna_banka.service.LegalEntityService;
import poslovna_banka.service.dto.LegalEntityDTO;

@Service
public class LegalEntityServiceImpl implements LegalEntityService{
	
	@Autowired
	private LegalEntityRepository repo;
	
	@Autowired
	private ActivityRepository actRepo;

	@Override
	public LegalEntity addLegalEntity(LegalEntity le) {
		return repo.save(le);
	}

	@Override
	public LegalEntity modifyLegalEntity(Long id, LegalEntityDTO le) {
		System.out.println("=================---============");
		LegalEntity updated = repo.findOne(id);
		updated.setAbbreviatedName(le.getAbbreviatedName());
		updated.setAdress(le.getAdress());
		updated.setDeliveringAdress(le.getDeliveringAdress());
		updated.setEmail(le.getEmail());
		updated.setJmbg(le.getJmbg());
		updated.setMbr(le.getMbr());
		updated.setName(le.getName());
		updated.setPhoneNumber(le.getPhoneNumber());
		updated.setPib(le.getPib());
		updated.setTaxAuthority(le.getTaxAuthority());
		updated.setResponsiblePerson(le.getResponsiblePerson());
		updated.setActivity(actRepo.findByCode(le.getActivity()));
		return repo.save(updated);
	}

	@Override
	public List<LegalEntity> getAllLegalEntities() {
		return (List<LegalEntity>) repo.findAll();
	}

	@Override
	public LegalEntity getLegalEntity(Long id) {
		return repo.findOne(id);
	}

	@Override
	public void delete(Long id) {
		repo.delete(id);;
	}



}
