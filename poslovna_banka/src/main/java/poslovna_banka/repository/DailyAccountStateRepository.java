package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.BankAccount;
import poslovna_banka.model.DailyAccountState;

@Repository
public interface DailyAccountStateRepository extends CrudRepository<DailyAccountState, Long> {

	DailyAccountState findOneByDateAndBankAccount(String date, BankAccount bankAccount);

}
