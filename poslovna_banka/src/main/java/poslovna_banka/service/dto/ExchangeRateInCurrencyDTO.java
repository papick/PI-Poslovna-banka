package poslovna_banka.service.dto;

public class ExchangeRateInCurrencyDTO {
	
	
	private long idExchangeRate;
	
	private String primaryCurrency;
	
	private String toOtherCurrency;
	
	private String buying;
	
	private String middle;
	
	private String sell;
	
	
	public ExchangeRateInCurrencyDTO() {
		// TODO Auto-generated constructor stub
	}


	public ExchangeRateInCurrencyDTO(long idExchangeRate, String primaryCurrency, String toOtherCurrency,
			String buying, String middle, String sell) {
		super();

		this.idExchangeRate = idExchangeRate;
		this.primaryCurrency = primaryCurrency;
		this.toOtherCurrency = toOtherCurrency;
		this.buying = buying;
		this.middle = middle;
		this.sell = sell;
	}




	public long getIdExchangeRate() {
		return idExchangeRate;
	}


	public void setIdExchangeRate(long idExchangeRate) {
		this.idExchangeRate = idExchangeRate;
	}


	public String getPrimaryCurrency() {
		return primaryCurrency;
	}


	public void setPrimaryCurrency(String primaryCurrency) {
		this.primaryCurrency = primaryCurrency;
	}


	public String getToOtherCurrency() {
		return toOtherCurrency;
	}


	public void setToOtherCurrency(String toOtherCurrency) {
		this.toOtherCurrency = toOtherCurrency;
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


	public String getSell() {
		return sell;
	}


	public void setSell(String sell) {
		this.sell = sell;
	}
	
	
	

}
