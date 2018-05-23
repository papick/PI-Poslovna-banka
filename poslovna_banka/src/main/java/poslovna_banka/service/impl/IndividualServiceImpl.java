package poslovna_banka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Individual;
import poslovna_banka.repository.IndividualRepository;
import poslovna_banka.service.IndividualService;

@Service
public class IndividualServiceImpl implements IndividualService{

	@Autowired
	private IndividualRepository repo;
	
	@Override
	public Individual addIndividual(Individual i) {
		return repo.save(i);
	}

	@Override
	public Individual modifyIndividual(Individual i) {
		Individual updated = new Individual();
		updated.setAbbreviatedName(i.getAbbreviatedName());
		updated.setAdress(i.getAdress());
		updated.setDeliveringAdress(i.getDeliveringAdress());
		updated.setEmail(i.getEmail());
		updated.setJmbg(i.getJmbg());
		updated.setMailReport(i.isMailReport());
		updated.setName(i.getName());
		updated.setPhoneNumber(i.getPhoneNumber());
		return repo.save(updated);
	}

	@Override
	public List<Individual> getAllIndividuals() {
		return (List<Individual>) repo.findAll();
	}

}
