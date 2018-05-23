package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Currency")
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "officialCode", columnDefinition = "CHAR(3)" , unique =true )
	private String officialCode;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Country country;

	@Column
	private String name;

	@Column
	private Boolean domicilna;
	
	public Currency() {
	}

	public Currency(String officialCode, Country country, String name, Boolean domicilna) {
		super();
		this.officialCode = officialCode;
		this.country = country;
		this.name = name;
		this.domicilna = domicilna;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
