package poslovna_banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poslovna_banka.model.LegalEntity;

@Service
public interface LegalEntityService {

	public LegalEntity addLegalEntity(LegalEntity le);
	
	public LegalEntity modifyLegalEntity(LegalEntity le);
	
	public List<LegalEntity> getAllLegalEntities();
	
}
