package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long>{

	
	
}
