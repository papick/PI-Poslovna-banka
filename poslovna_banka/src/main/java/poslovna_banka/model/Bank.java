package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Bank")

public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "code", length = 3)
	private String code;
	
	@NotNull
	@Column(name = "PIB", length = 10)
	private String PIB;

	@NotNull
	@Column(name = "name", length = 120)
	private String name;

	@NotNull
	@Column(name = "address", length = 120)
	private String address;

	@Column(name = "email", length = 128)
	private String email;

	@Column(name = "web", length = 120)
	private String web;

	@Column(name = "telefon", length = 20)
	private String telefon;

	@Column(name = "fax", length = 20)
	private String fax;

	@NotNull
	@Column(name = "swift", length = 8)
	private String swiftCode;
	
	@NotNull
	@Column(name = "accountNumber", length = 18)
	private String accountNumber;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String code, String PIB, String name, String address, String email, String web, String telefon,
			String fax, String swiftCode, String accountNumber) {
		super();

		this.code = code;
		this.PIB = PIB;
		this.name = name;
		this.address = address;
		this.email = email;
		this.web = web;
		this.telefon = telefon;
		this.fax = fax;
		this.swiftCode = swiftCode;
		this.accountNumber = accountNumber;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
