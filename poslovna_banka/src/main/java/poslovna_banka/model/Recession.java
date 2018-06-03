package poslovna_banka.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "Recession")
public class Recession {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String dateOfRecession;
	
	@ManyToOne
	@NotNull
	private BankAccount accountTo;
	
	
	@ManyToOne
	@NotNull
	private BankAccount accountFrom;

	public Recession() {
		this.dateOfRecession = Date.valueOf(LocalDate.now()).toString();
	}
	public Recession(String dateOfRecession, BankAccount accountTo, BankAccount accountFrom) {
		super();
		this.dateOfRecession = dateOfRecession;
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateOfRecession() {
		return dateOfRecession;
	}

	public void setDateOfRecession(String dateOfRecession) {
		this.dateOfRecession = dateOfRecession;
	}

	public BankAccount getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(BankAccount accountTo) {
		this.accountTo = accountTo;
	}

	public BankAccount getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(BankAccount accoutFrom) {
		this.accountFrom = accoutFrom;
	}
	
	
}
