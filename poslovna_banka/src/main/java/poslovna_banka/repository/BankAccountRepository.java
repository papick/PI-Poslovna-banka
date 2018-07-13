package poslovna_banka.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Bank;
import poslovna_banka.model.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
	BankAccount findOneByNumber(String number);
	
	List<BankAccount> findAllByBank(Bank bank);
}
