package poslovna_banka.service.dto;

import poslovna_banka.model.Country;

public class CurrencyEditDTO {
	
	private String officialCode;
	
	private Country country;
	
	private String name;

	private Boolean domicilna;
	
	public CurrencyEditDTO() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyEditDTO(String officialCode, Country country, String name, Boolean domicilna) {
		super();
		this.officialCode = officialCode;
		this.country = country;
		this.name = name;
		this.domicilna = domicilna;
	}

	public String getOfficialCode() {
		return officialCode;
	}

	public void setOfficialCode(String officialCode) {
		this.officialCode = officialCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDomicilna() {
		return domicilna;
	}

	public void setDomicilna(Boolean domicilna) {
		this.domicilna = domicilna;
	}
	
	

}
