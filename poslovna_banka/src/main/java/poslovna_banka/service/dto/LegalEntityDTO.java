package poslovna_banka.service.dto;

public class LegalEntityDTO {
	
	private String name;

	private String abbreviatedName;

	private String adress;

	private String phoneNumber;

	private String jmbg;

	private String email;

	private String mbr;

	private String taxAuthority;

	private String pib;

	private String deliveringAdress;

	private boolean mailReport;

	private String activity;
	
	private String responsiblePerson;
	
	public LegalEntityDTO(){}

	public LegalEntityDTO(String name, String abbreviatedName, String adress, String phoneNumber, String jmbg,
			String email, String mbr, String taxAuthority, String pib, String deliveringAdress, boolean mailReport,
			String activity, String responsiblePerson) {
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
		this.mailReport = mailReport;
		this.activity = activity;
		this.responsiblePerson = responsiblePerson;
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

	public boolean isMailReport() {
		return mailReport;
	}

	public void setMailReport(boolean mailReport) {
		this.mailReport = mailReport;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

}
