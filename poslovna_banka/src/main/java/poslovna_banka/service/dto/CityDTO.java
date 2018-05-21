package poslovna_banka.service.dto;

public class CityDTO {

	private Long countryId;

	private String name;

	private String code;

	private String postNum;

	private String country;

	public CityDTO() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CityDTO(Long countryId, String name, String code, String postNum, String country) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.code = code;
		this.postNum = postNum;
		this.country = country;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

}
