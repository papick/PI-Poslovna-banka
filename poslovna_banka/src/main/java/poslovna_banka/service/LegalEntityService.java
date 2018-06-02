package poslovna_banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poslovna_banka.model.LegalEntity;
import poslovna_banka.service.dto.LegalEntityDTO;

@Service
public interface LegalEntityService {

	public LegalEntity addLegalEntity(LegalEntity le);
	
	public LegalEntity modifyLegalEntity(Long id, LegalEntityDTO le);
	
	public List<LegalEntity> getAllLegalEntities();
	
	public LegalEntity getLegalEntity(Long id);
	
	public void delete(Long id);
	
}
