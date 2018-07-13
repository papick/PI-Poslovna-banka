package poslovna_banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna_banka.model.Clearing;

public interface ClearingRepository  extends JpaRepository<Clearing, Long> {
	public Clearing findByBankFromIdAndBankToIdAndDone(Long bankFromId ,Long bankToId, boolean done);
}
