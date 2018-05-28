package poslovna_banka.service.dto;

import poslovna_banka.model.Individual;

public class BankAccountDTO {

	private String number;

	private String dateOfOpenning;

	private boolean valid;

	private String bank;

	private Individual individual;

	private LegalEntityDTO legalEntity;

	private String currency;
	
	public BankAccountDTO(){}

	public BankAccountDTO(String number, String dateOfOpenning, boolean valid, String bank, Individual individual,
			LegalEntityDTO legalEntity, String currency) {
		super();
		this.number = number;
		this.dateOfOpenning = dateOfOpenning;
		this.valid = valid;
		this.bank = bank;
		this.individual = individual;
		this.legalEntity = legalEntity;
		this.currency = currency;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDateOfOpenning() {
		return dateOfOpenning;
	}

	public void setDateOfOpenning(String dateOfOpenning) {
		this.dateOfOpenning = dateOfOpenning;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public LegalEntityDTO getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntityDTO legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
