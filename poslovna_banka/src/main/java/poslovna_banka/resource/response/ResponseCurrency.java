package poslovna_banka.resource.response;

import java.util.Currency;

public class ResponseCurrency {
	
	private Currency currency;
	
	public ResponseCurrency() {
		// TODO Auto-generated constructor stub
	}
		

	public ResponseCurrency(Currency currency) {
		super();
		this.currency = currency;
	}


	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	
	

}
