package poslovna_banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
