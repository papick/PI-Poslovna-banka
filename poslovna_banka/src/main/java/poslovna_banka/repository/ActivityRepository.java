package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
	
	public Activity findByCode(String name);

}
