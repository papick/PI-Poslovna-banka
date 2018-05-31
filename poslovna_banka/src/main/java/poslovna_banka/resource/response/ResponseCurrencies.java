package poslovna_banka.resource.response;

import java.util.ArrayList;

import poslovna_banka.model.Currency;

public class ResponseCurrencies {
	
	private ArrayList<Currency> currencies;
	
	public ResponseCurrencies() {
		// TODO Auto-generated constructor stub
	}

	public ResponseCurrencies(ArrayList<Currency> currencies) {
		super();
		this.currencies = currencies;
	}

	public ArrayList<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(ArrayList<Currency> currencies) {
		this.currencies = currencies;
	}
	
	

}
