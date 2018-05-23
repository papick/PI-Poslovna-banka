package poslovna_banka.service.impl;

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

}
