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
	private Date date;

	@NotNull
	@Column(name = "previous_state")
	private String previousState;

	@NotNull
	@Column(name = "payment_to")
	private String paymentTo;

	@NotNull
	@Column(name = "payment_from")
	private String paymentFrom;

	@NotNull
	@Column(name = "new_state")
	private String newState;

	@ManyToOne
	private BankAccount bankAccount;

	public DailyAccountState() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DailyAccountState(Date date, String previousState, String paymentTo, String paymentFrom, String newState,
			BankAccount bankAccount) {
		super();
		this.date = date;
		this.previousState = previousState;
		this.paymentTo = paymentTo;
		this.paymentFrom = paymentFrom;
		this.newState = newState;
		this.bankAccount = bankAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPreviousState() {
		return previousState;
	}

	public void setPreviousState(String previousState) {
		this.previousState = previousState;
	}

	public String getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}

	public String getPaymentFrom() {
		return paymentFrom;
	}

	public void setPaymentFrom(String paymentFrom) {
		this.paymentFrom = paymentFrom;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

}
