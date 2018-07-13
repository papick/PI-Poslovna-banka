package poslovna_banka.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.BankAccount;
import poslovna_banka.repository.BankAccountRepository;
import poslovna_banka.repository.BankRepository;
import poslovna_banka.repository.CurrencyRepository;
import poslovna_banka.repository.IndividualRepository;
import poslovna_banka.repository.LegalEntityRepository;
import poslovna_banka.service.BankAccountService;
import poslovna_banka.service.dto.BankAccountDTO;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired

	private BankAccountRepository repo;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Autowired
	private LegalEntityRepository legalRepo;
	
	@Autowired
	private IndividualRepository individualRepo;
	
	@Autowired
	private CurrencyRepository currRepo;

	@Override
	public BankAccount addBankAccount(BankAccount ba) {
		
		/*String numberOfAccount = (ba.getBank().getCode()).concat(ba.getNumber());
		System.out.println("Broj racuna => " + numberOfAccount);*/
		
		String bankPIB = ba.getBank().getPIB();
		String controlNumber = "97";
		int numb = ((List<BankAccount>) repo.findAll()).size()+1;
		String formatted = String.format("%013d", numb);
		String numberOfAccount = bankPIB + formatted + controlNumber;		
		System.out.println("BROJ RACUNAAA " + numberOfAccount);
		ba.setNumber(numberOfAccount);
		return repo.save(ba);
	}

	@Override
	public BankAccount modifyLegalBankAccount(BankAccountDTO ba, Long id) {
		BankAccount updated = repo.findOne(id);
		updated.setBank(bankRepo.findOne(Long.parseLong(ba.getBank())));
		updated.setLegalEntity(legalRepo.findByName(ba.getLegalEntity()));
		//updated.setNumber(ba.getNumber());
		updated.setValid(ba.isValid());
		updated.setCurrency(currRepo.findOneByName(ba.getCurrency()));
		updated.setMailReporting(ba.isMailReporting());
		return repo.save(updated);
	}
	
	@Override
	public BankAccount modifyIndividualBankAccount(BankAccountDTO ba, Long id) {
		BankAccount updated = repo.findOne(id);
		updated.setBank(bankRepo.findOne(Long.parseLong(ba.getBank())));
		updated.setIndividual(individualRepo.findByName(ba.getIndividual()));
		//updated.setNumber(ba.getNumber());
		updated.setValid(ba.isValid());
		updated.setCurrency(currRepo.findOneByName(ba.getCurrency()));
		updated.setMailReporting(ba.isMailReporting());
		return repo.save(updated);
	}

	@Override
	public List<BankAccount> getAllBankAccounts() {
		List<BankAccount> accounts = new ArrayList<>() ;
		repo.findAll().forEach(ba -> {
			if(ba.isValid()) {
				accounts.add(ba);
			}
		});
		return accounts;
	}

	@Override
	public List<BankAccount> getAllLegalEntities() {
		List<BankAccount> accounts = this.getAllBankAccounts();
		List<BankAccount> legals = new ArrayList<BankAccount>();
		for (BankAccount ba : accounts) {
			if (ba.getLegalEntity() != null) {
				legals.add(ba);
			}
		}
		return legals;
	}

	@Override
	public List<BankAccount> getAllIndividuals() {
		List<BankAccount> accounts = this.getAllBankAccounts();
		List<BankAccount> indvs = new ArrayList<BankAccount>();
		for (BankAccount ba : accounts) {
			if (ba.getLegalEntity() == null) {
				indvs.add(ba);
			}
		}
		return indvs;
	}

	@Override
	public BankAccount getBankAccount(Long id) {
		return repo.findOne(id);
	}

	@Override
	public void cancelAccount(Long id) {
		BankAccount account = repo.findOne(id);
		account.setValid(false);
		repo.save(account);
		
	}

}
