package poslovna_banka.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.BankAccount;

@Repository
public interface AnalyticOfStatementRepository extends CrudRepository<AnalyticOfStatement, Long> {
	
	public List<AnalyticOfStatement> findAllByDebtorAccount(BankAccount acc);
	
	public List<AnalyticOfStatement> findAllByAccountCreditor(BankAccount acc);
	
}
