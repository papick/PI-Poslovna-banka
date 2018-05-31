package poslovna_banka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.LegalEntity;
import poslovna_banka.repository.LegalEntityRepository;
import poslovna_banka.service.LegalEntityService;

@Service
public class LegalEntityServiceImpl implements LegalEntityService{
	
	@Autowired
	
	private LegalEntityRepository repo;

	@Override
	public LegalEntity addLegalEntity(LegalEntity le) {
		return repo.save(le);
	}

	@Override
	public LegalEntity modifyLegalEntity(LegalEntity le) {
		LegalEntity updated = new LegalEntity();
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
		return repo.save(updated);
	}

	@Override
	public List<LegalEntity> getAllLegalEntities() {
		return (List<LegalEntity>) repo.findAll();
	}



}
