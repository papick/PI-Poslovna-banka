package poslovna_banka.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "analyticsOfStatements")
public class AnalyticOfStatement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	@Column(name = "debtor")
	private String debtor; // duznik

	@NotNull
	@Column(name = "purposeOfPayment")
	private String purposeOfPayment;

	@NotNull
	@Column(name = "creditor")
	private String creditor; // nalogodavac

	@NotNull
	private Date dateOfReceipt; // datum prijema

	@NotNull
	private Date currencyDate; // datum valute

	private Integer modelAssigments; // model zaduzenja

	private String referenceNumberAssigments; // poziv na broj zaduzenja

	@ManyToOne
	private BankAccount debtorAccount; // racun duznika

	@ManyToOne
	private String accountCreditor; // racun poverioca

	private Integer modelApproval; // model odobrenja

	private String referenceNumberCreditor; // poziv na broj odobrenja

	private Boolean emergency;

	private Float sum;

	private Integer typeOfMistake;

	@Column(length = 1)
	@XmlElement
	private String status;

	@ManyToOne
	private PaymentType paymentType; // tip placanja

	@ManyToOne
	private Currency paymentCurrency; // valuta placanja

	@ManyToOne
	private City city;

	public AnalyticOfStatement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnalyticOfStatement(String debtor, String purposeOfPayment, String creditor, Date dateOfReceipt,
			Date currencyDate, Integer modelAssigments, String referenceNumberAssigments, BankAccount debtorAccount,
			String accountCreditor, Integer modelApproval, String referenceNumberCreditor, Boolean emergency, Float sum,
			Integer typeOfMistake, String status, PaymentType paymentType, Currency paymentCurrency, City city) {
		super();
		this.debtor = debtor;
		this.purposeOfPayment = purposeOfPayment;
		this.creditor = creditor;
		this.dateOfReceipt = dateOfReceipt;
		this.currencyDate = currencyDate;
		this.modelAssigments = modelAssigments;
		this.referenceNumberAssigments = referenceNumberAssigments;
		this.debtorAccount = debtorAccount;
		this.accountCreditor = accountCreditor;
		this.modelApproval = modelApproval;
		this.referenceNumberCreditor = referenceNumberCreditor;
		this.emergency = emergency;
		this.sum = sum;
		this.typeOfMistake = typeOfMistake;
		this.status = status;
		this.paymentType = paymentType;
		this.paymentCurrency = paymentCurrency;
		this.city = city;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDebtor() {
		return debtor;
	}

	public void setDebtor(String debtor) {
		this.debtor = debtor;
	}

	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	public String getCreditor() {
		return creditor;
	}

	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}

	public Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	public void setDateOfReceipt(Date dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}

	public Integer getModelAssigments() {
		return modelAssigments;
	}

	public void setModelAssigments(Integer modelAssigments) {
		this.modelAssigments = modelAssigments;
	}

	public String getReferenceNumberAssigments() {
		return referenceNumberAssigments;
	}

	public void setReferenceNumberAssigments(String referenceNumberAssigments) {
		this.referenceNumberAssigments = referenceNumberAssigments;
	}

	public BankAccount getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(BankAccount debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public String getAccountCreditor() {
		return accountCreditor;
	}

	public void setAccountCreditor(String accountCreditor) {
		this.accountCreditor = accountCreditor;
	}

	public Integer getModelApproval() {
		return modelApproval;
	}

	public void setModelApproval(Integer modelApproval) {
		this.modelApproval = modelApproval;
	}

	public String getReferenceNumberCreditor() {
		return referenceNumberCreditor;
	}

	public void setReferenceNumberCreditor(String referenceNumberCreditor) {
		this.referenceNumberCreditor = referenceNumberCreditor;
	}

	public Boolean getEmergency() {
		return emergency;
	}

	public void setEmergency(Boolean emergency) {
		this.emergency = emergency;
	}

	public Float getSum() {
		return sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	public Integer getTypeOfMistake() {
		return typeOfMistake;
	}

	public void setTypeOfMistake(Integer typeOfMistake) {
		this.typeOfMistake = typeOfMistake;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Currency getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(Currency paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
