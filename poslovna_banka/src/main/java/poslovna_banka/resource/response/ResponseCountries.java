package poslovna_banka.resource.response;

import java.util.ArrayList;

import poslovna_banka.model.Country;

public class ResponseCountries {

	private ArrayList<Country> countries;

	public ResponseCountries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseCountries(ArrayList<Country> countries) {
		super();
		this.countries = countries;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

}
