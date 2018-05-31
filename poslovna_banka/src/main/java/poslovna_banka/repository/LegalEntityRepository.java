package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.LegalEntity;
@Repository
public interface LegalEntityRepository extends CrudRepository<LegalEntity, Long>{

	public LegalEntity findByName(String name);
}
