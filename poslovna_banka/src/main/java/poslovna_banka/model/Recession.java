package poslovna_banka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "Recession")
public class Recession {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String dateOfRecession;
	
	@NotNull
	@Size(max = 20)
	private String accountTo;
	
	@ManyToOne
	private BankAccount accountFrom;

	public Recession() {
		
	}
	public Recession(String dateOfRecession, String accountTo, BankAccount accountFrom) {
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

	public String getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}

	public BankAccount getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(BankAccount accoutFrom) {
		this.accountFrom = accoutFrom;
	}
	
	
}
