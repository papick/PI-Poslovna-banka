package poslovna_banka.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Clearing {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@ManyToOne
	private Bank bankFrom;
	
	@NotNull
	@ManyToOne
	private Bank bankTo;
	
	@NotNull
	@ManyToOne
	private Currency currency;


	@NotNull
	private String dateOfCurrency;
	
	@OneToMany
	private List<AnalyticOfStatement> payments;
	
	@NotNull
	private boolean done;
	
	@NotNull
	private double sumAll;

	public Clearing() {
		this.sumAll = 0;
	}
	
	public Clearing( Bank bankFrom, Bank bankTo, Currency currency, String dateOfCurrency,
			List<AnalyticOfStatement> payments, double sumAll) {
		super();
		this.bankFrom = bankFrom;
		this.bankTo = bankTo;
		this.currency = currency;
		this.dateOfCurrency = dateOfCurrency;
		this.payments = payments;
		this.sumAll = sumAll;
		this.done = false;
	}
	
	
	public double getSumAll() {
		return sumAll;
	}

	public void setSumAll(double sumAll) {
		this.sumAll = sumAll;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bank getBankFrom() {
		return bankFrom;
	}

	public void setBankFrom(Bank bankFrom) {
		this.bankFrom = bankFrom;
	}

	public Bank getBankTo() {
		return bankTo;
	}

	public void setBankTo(Bank bankTo) {
		this.bankTo = bankTo;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getDateOfCurrency() {
		return dateOfCurrency;
	}

	public void setDateOfCurrency(String dateOfCurrency) {
		this.dateOfCurrency = dateOfCurrency;
	}

	public List<AnalyticOfStatement> getPayments() {
		return payments;
	}

	public void setPayments(List<AnalyticOfStatement> payments) {
		this.payments = payments;
	}
	
	
	
	
	
}
