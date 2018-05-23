package poslovna_banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poslovna_banka.model.BankAccount;

@Service
public interface BankAccountService {
	
	public BankAccount addBankAccount(BankAccount ba);
	
	public BankAccount modifyBankAccount(BankAccount ba);
	
	public List<BankAccount> getAllBankAccounts();
	
	public List<BankAccount> getAllLegalEntities();
	
	public List<BankAccount> getAllIndividuals();

}
