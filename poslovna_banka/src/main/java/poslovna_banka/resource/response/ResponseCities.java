package poslovna_banka.resource.response;

import java.util.ArrayList;

import poslovna_banka.model.City;

public class ResponseCities {

	private ArrayList<City> cities;

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public ResponseCities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseCities(ArrayList<City> cities) {
		super();
		this.cities = cities;
	}

}
