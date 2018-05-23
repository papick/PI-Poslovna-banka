package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Individual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String abbreviatedName;
	
	@NotNull
	private String adress;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	@Column(length = 13)
	private String jmbg;
	
	@NotNull
	private String email;
	
	private String deliveringAdress;
	
	private boolean mailReport;

	public Individual(String name, String abbreviatedName, String adress, String phoneNumber, String jmbg, String email,
			String deliveringAdress, boolean mailReport) {
		super();
		this.name = name;
		this.abbreviatedName = abbreviatedName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.jmbg = jmbg;
		this.email = email;
		this.deliveringAdress = deliveringAdress;
		this.mailReport = mailReport;
	}
	
	public Individual(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviatedName() {
		return abbreviatedName;
	}

	public void setAbbreviatedName(String abbreviatedName) {
		this.abbreviatedName = abbreviatedName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveringAdress() {
		return deliveringAdress;
	}

	public void setDeliveringAdress(String deliveringAdress) {
		this.deliveringAdress = deliveringAdress;
	}

	public boolean isMailReport() {
		return mailReport;
	}

	public void setMailReport(boolean mailReport) {
		this.mailReport = mailReport;
	}
}
