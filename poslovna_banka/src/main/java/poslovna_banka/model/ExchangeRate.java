package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "ExchangeRate")
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Bank bank;
	
	@Column
	private String date;
	
	@Column
	private int number;
	
	@Column
	private String appliedFromDate;
	
	
	public ExchangeRate() {
		// TODO Auto-generated constructor stub
	}


	public ExchangeRate(Bank bank, String date, int number, String appliedFromDate) {
		super();
		this.bank = bank;
		this.date = date;
		this.number = number;
		this.appliedFromDate = appliedFromDate;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getAppliedFromDate() {
		return appliedFromDate;
	}


	public void setAppliedFromDate(String appliedFromDate) {
		this.appliedFromDate = appliedFromDate;
	}
	
	
	
	
	// test
	
	
}
