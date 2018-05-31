package poslovna_banka.service.dto;

public class BankAccountDTO {

	private String number;

	private String dateOfOpenning;

	private boolean valid;

	private String bank;

	private String individual;

	private String legalEntity;

	private String currency;
	
	private boolean mailReporting;
	
	public BankAccountDTO(){}

	public BankAccountDTO(String number, String dateOfOpenning, boolean valid, String bank, String individual,
			String legalEntity, String currency, boolean mr) {
		super();
		this.number = number;
		this.dateOfOpenning = dateOfOpenning;
		this.valid = valid;
		this.bank = bank;
		this.individual = individual;
		this.legalEntity = legalEntity;
		this.currency = currency;
		this.mailReporting = mr;
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

	public String getIndividual() {
		return individual;
	}

	public void setIndividual(String individual) {
		this.individual = individual;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isMailReporting() {
		return mailReporting;
	}

	public void setMailReporting(boolean mailReporting) {
		this.mailReporting = mailReporting;
	}
}
