package poslovna_banka.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	
	private BankAccountRepository repo;

	@Override
	public BankAccount addBankAccount(BankAccount ba) {
		return repo.save(ba);
	}

	@Override
	public BankAccount modifyBankAccount(BankAccount ba) {
		BankAccount updated = new BankAccount();
		updated.setBank(ba.getBank());
		updated.setDateOfOpenning(ba.getDateOfOpenning());
		updated.setIndividual(ba.getIndividual());
		updated.setLegalEntity(ba.getLegalEntity());
		updated.setNumber(ba.getNumber());
		updated.setValid(ba.isValid());
		return repo.save(updated);
	}

	@Override
	public List<BankAccount> getAllBankAccounts() {
		return (List<BankAccount>) repo.findAll();
	}

	@Override
	public List<BankAccount> getAllLegalEntities() {
		List<BankAccount> accounts=this.getAllBankAccounts();
		List<BankAccount> legals = new ArrayList<BankAccount>();
		for(BankAccount ba : accounts){
			if( ba.getLegalEntity() != null ){
				legals.add(ba);
			}
		}
		return legals;
	}

	@Override
	public List<BankAccount> getAllIndividuals() {
		List<BankAccount> accounts=this.getAllBankAccounts();
		List<BankAccount> indvs = new ArrayList<BankAccount>();
		for(BankAccount ba : accounts){
			if( ba.getLegalEntity() == null ){
				indvs.add(ba);
			}
		}
		return indvs;
	}

}
