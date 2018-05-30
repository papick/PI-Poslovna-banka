package poslovna_banka.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String number;

	// @NotNull
	private String dateOfOpenning;

	private boolean valid;

	@ManyToOne
	private Bank bank;

	@ManyToOne()
	private Individual individual;

	@ManyToOne()
	private LegalEntity legalEntity;

	@OneToOne
	private Currency currency;

	public BankAccount() {
	}

	public BankAccount(String number, Bank bank, LegalEntity legalEntity) {
		super();
		this.number = number;
		this.bank = bank;
		this.legalEntity = legalEntity;
	}

	public BankAccount(String number, String dateOfOpenning, boolean valid, Bank bank, Individual individual,
			LegalEntity legalEntity, Currency currency) {
		super();
		this.number = number;
		this.dateOfOpenning = dateOfOpenning;
		this.valid = valid;
		this.bank = bank;
		this.individual = individual;
		this.legalEntity = legalEntity;
		this.currency = currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", number=" + number + ", dateOfOpenning=" + dateOfOpenning + ", valid="
				+ valid + ", bank=" + bank + ", individual=" + individual + ", legalEntity=" + legalEntity
				+ ", currency=" + currency + "]";
	}

}
