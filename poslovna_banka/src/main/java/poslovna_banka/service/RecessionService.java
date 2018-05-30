package poslovna_banka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Recession;
import poslovna_banka.repository.RecessionRepository;

@Service
public class RecessionService {
	
	@Autowired
	private RecessionRepository recessionRepository;
	
	public void addRecession(Recession recession) {
		recessionRepository.save(recession);
	}
	
	public List<Recession> getAllRecessions(Recession recession) {
		List<Recession> recessions =  new ArrayList<>();
		recessionRepository.findAll().forEach(recessions::add);
		return recessions;
	}
	
	public void deleteRecession(Long id) {
		recessionRepository.delete(id);
	}
}
