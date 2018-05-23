package poslovna_banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
