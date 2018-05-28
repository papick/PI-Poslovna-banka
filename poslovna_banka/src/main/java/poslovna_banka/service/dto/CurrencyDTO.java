package poslovna_banka.service.dto;

import poslovna_banka.model.Country;

public class CurrencyDTO {

	private String officialCode;
	
	
	private String name;
	
	private Boolean domicilna;
	
	
	public CurrencyDTO() {
		// TODO Auto-generated constructor stub
	}


	public CurrencyDTO(String officialCode,  String name, Boolean domicilna) {
		super();
		this.officialCode = officialCode;
		this.name = name;
		this.domicilna = domicilna;
	}


	public String getOfficialCode() {
		return officialCode;
	}


	public void setOfficialCode(String officialCode) {
		this.officialCode = officialCode;
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
