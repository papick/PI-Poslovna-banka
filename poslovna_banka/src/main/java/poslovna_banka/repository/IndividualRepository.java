package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Individual;

@Repository
public interface IndividualRepository extends CrudRepository<Individual, Long>{
	public Individual findByName(String name);

}
