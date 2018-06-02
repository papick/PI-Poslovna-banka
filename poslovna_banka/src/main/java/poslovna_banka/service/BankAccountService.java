package poslovna_banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poslovna_banka.model.Bank;
import poslovna_banka.model.BankAccount;
import poslovna_banka.service.dto.BankAccountDTO;

@Service
public interface BankAccountService {
	
	public BankAccount addBankAccount(BankAccount ba);
	
	public BankAccount modifyLegalBankAccount(BankAccountDTO ba, Long id);
	
	public List<BankAccount> getAllBankAccounts();
	
	public List<BankAccount> getAllLegalEntities();
	
	public List<BankAccount> getAllIndividuals();
	
	public BankAccount getBankAccount(Long id);

}
