package poslovna_banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poslovna_banka.model.Individual;

@Service
public interface IndividualService {
	
	public Individual addIndividual(Individual i);
	
	public Individual modifyIndividual(Individual i);
	
	public List<Individual> getAllIndividuals();

}
