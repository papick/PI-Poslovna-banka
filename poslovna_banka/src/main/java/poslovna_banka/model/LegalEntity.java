package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class LegalEntity {

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

	@NotNull
	private String mbr;

	@NotNull
	private String taxAuthority;

	@Column(length = 10)
	private String pib;

	private String deliveringAdress;

	@OneToOne
	private Activity activity;
	
	@NotNull
	private String responsiblePerson;

	public LegalEntity() {
	}

	public LegalEntity(String name, String abbreviatedName, String adress, String phoneNumber, String jmbg,
			String email, String mbr, String taxAuthority, String pib, String deliveringAdress,
			Activity activity, String responsiblePerson) {
		super();
		this.name = name;
		this.abbreviatedName = abbreviatedName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.jmbg = jmbg;
		this.email = email;
		this.mbr = mbr;
		this.taxAuthority = taxAuthority;
		this.pib = pib;
		this.deliveringAdress = deliveringAdress;
		this.activity = activity;
		this.responsiblePerson = responsiblePerson;
	}

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

	public String getMbr() {
		return mbr;
	}

	public void setMbr(String mbr) {
		this.mbr = mbr;
	}

	public String getTaxAuthority() {
		return taxAuthority;
	}

	public void setTaxAuthority(String taxAuthority) {
		this.taxAuthority = taxAuthority;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getDeliveringAdress() {
		return deliveringAdress;
	}

	public void setDeliveringAdress(String deliveringAdress) {
		this.deliveringAdress = deliveringAdress;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

}
