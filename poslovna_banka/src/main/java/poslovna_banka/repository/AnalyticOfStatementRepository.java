package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.AnalyticOfStatement;

@Repository
public interface AnalyticOfStatementRepository extends CrudRepository<AnalyticOfStatement, Long> {

}
