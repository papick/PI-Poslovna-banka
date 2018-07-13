package poslovna_banka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.BankRepository;

@Service
public class ReportsService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	
	public List<BankAccount> getBankAccountsByBank(Long id) {
		
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		accounts = bankAccountRepository.findAllByBank(bankRepository.findOne(id));
		
		
		
		
		
		return accounts;
	}

}
