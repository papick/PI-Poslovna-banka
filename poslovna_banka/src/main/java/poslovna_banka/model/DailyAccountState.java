package poslovna_banka.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Daily_account_state")
public class DailyAccountState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "date")
	private String date;

	@NotNull
	@Column(name = "previous_state")
	private Double previousState;

	@NotNull
	@Column(name = "payment_to")
	private Double paymentTo; // promet u korist

	@NotNull
	@Column(name = "payment_from")
	private Double paymentFrom; // promet na teret

	@NotNull
	@Column(name = "new_state")
	private Double newState;

	@ManyToOne
	private BankAccount bankAccount;

	public DailyAccountState() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPreviousState() {
		return previousState;
	}

	public void setPreviousState(Double previousState) {
		this.previousState = previousState;
	}

	public Double getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(Double paymentTo) {
		this.paymentTo = paymentTo;
	}

	public Double getPaymentFrom() {
		return paymentFrom;
	}

	public void setPaymentFrom(Double paymentFrom) {
		this.paymentFrom = paymentFrom;
	}

	public Double getNewState() {
		return newState;
	}

	public void setNewState(Double newState) {
		this.newState = newState;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public DailyAccountState(String date, Double previousState, Double paymentTo, Double paymentFrom, Double newState,
			BankAccount bankAccount) {
		super();
		this.date = date;
		this.previousState = previousState;
		this.paymentTo = paymentTo;
		this.paymentFrom = paymentFrom;
		this.newState = newState;
		this.bankAccount = bankAccount;
	}

}
