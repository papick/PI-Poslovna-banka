package poslovna_banka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Rtgs {
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
	@OneToOne
	private AnalyticOfStatement payment;
	
	

	public Rtgs(Bank bankFrom, Bank bankTo, AnalyticOfStatement payment) {
		super();
		this.bankFrom = bankFrom;
		this.bankTo = bankTo;
		this.payment = payment;
	}
	public Rtgs() {}

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

	public AnalyticOfStatement getPayment() {
		return payment;
	}

	public void setPayment(AnalyticOfStatement payment) {
		this.payment = payment;
	}
	
	
}
