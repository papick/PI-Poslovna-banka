package poslovna_banka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Clearing;
import poslovna_banka.repository.ClearingRepository;

@Service
public class ClearingService {
	@Autowired
	private ClearingRepository clearingRepository;
	
	public void saveClearing(Clearing clearing) {
		clearingRepository.save(clearing);
	}
	
	public List<Clearing> getClearings() {
		return clearingRepository.findAll();
	}
	
	public Clearing getClearing(Long id) {
		return clearingRepository.findOne(id);
	}
	public Clearing getLastClearingForBank(Long bankFromId, Long bankToId) {

		return clearingRepository.findByBankFromIdAndBankToIdAndDone(bankFromId,bankToId, false);
	
	}
	
	public void removeClearing(Long id) {
		clearingRepository.delete(id);
	}
	
	
}
