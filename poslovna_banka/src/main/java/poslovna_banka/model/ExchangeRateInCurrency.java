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
	private float buying;
	
	@Column
	private float middle;
	
	@Column
	private float selling;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private ExchangeRate exchangeRate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Currency primaryCurrency;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Currency toOtherCurrency;
	
	
	public ExchangeRateInCurrency() {
		// TODO Auto-generated constructor stub
	}


	public ExchangeRateInCurrency(float buying, float middle, float selling, ExchangeRate exchangeRate,
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


	public float getBuying() {
		return buying;
	}


	public void setBuying(float buying) {
		this.buying = buying;
	}


	public float getMiddle() {
		return middle;
	}


	public void setMiddle(float middle) {
		this.middle = middle;
	}


	public float getSelling() {
		return selling;
	}


	public void setSelling(float selling) {
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
