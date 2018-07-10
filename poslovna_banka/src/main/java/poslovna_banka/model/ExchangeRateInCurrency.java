package poslovna_banka.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "ExchangeRateInCurrency")
public class ExchangeRateInCurrency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String buying;
	
	@Column
	private String middle;
	
	@Column
	private String selling;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private ExchangeRate exchangeRate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Currency primaryCurrency;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Currency toOtherCurrency;
	
	
	public ExchangeRateInCurrency() {
		// TODO Auto-generated constructor stub
	}


	public ExchangeRateInCurrency(String buying, String middle, String selling, ExchangeRate exchangeRate,
			Currency primaryCurrency, Currency toOtherCurrency) {
		super();
		this.buying = buying;
		this.middle = middle;
		this.selling = selling;
		this.exchangeRate = exchangeRate;
		this.primaryCurrency = primaryCurrency;
		this.toOtherCurrency = toOtherCurrency;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getBuying() {
		return buying;
	}


	public void setBuying(String buying) {
		this.buying = buying;
	}


	public String getMiddle() {
		return middle;
	}


	public void setMiddle(String middle) {
		this.middle = middle;
	}


	public String getSelling() {
		return selling;
	}


	public void setSelling(String selling) {
		this.selling = selling;
	}


	public ExchangeRate getExchangeRate() {
		return exchangeRate;
	}


	public void setExchangeRate(ExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


	public Currency getPrimaryCurrency() {
		return primaryCurrency;
	}


	public void setPrimaryCurrency(Currency primaryCurrency) {
		this.primaryCurrency = primaryCurrency;
	}


	public Currency getToOtherCurrency() {
		return toOtherCurrency;
	}


	public void setToOtherCurrency(Currency toOtherCurrency) {
		this.toOtherCurrency = toOtherCurrency;
	}
	
	
	 // test
	

}
