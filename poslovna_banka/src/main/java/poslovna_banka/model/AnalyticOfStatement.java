package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "analyticsOfStatements")
public class AnalyticOfStatement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String type;

	@NotNull
	private String debtor; // isplatilac-platilac-duznik-nalogodavac

	@NotNull
	private String purposeOfPayment;

	@NotNull
	private String creditor; // poverilac-primalac

	@NotNull
	private String dateOfReceipt; // datum prijema

	@NotNull
	private String currencyDate; // datum valute

	private Integer modelAssigments; // model zaduzenja

	private String referenceNumberAssigments; // poziv na broj zaduzenja

	@Transient
	private String debtorAccountXML; // racun duznika za xml

	@ManyToOne
	private BankAccount debtorAccount; // racun duznika

	@Transient
	private String accountCreditorXML;

	@ManyToOne
	private BankAccount accountCreditor; // racun poverioca

	private Integer modelApproval; // model odobrenja

	private String referenceNumberCreditor; // poziv na broj odobrenja

	private Boolean emergency;

	private Double sum;

	private Integer typeOfMistake;

	@Column(length = 1)
	private String status;

	@Transient
	private String paymentTypeXML;

	@ManyToOne
	private PaymentType paymentType; // tip placanja

	@Transient
	private String paymentCurrencyXML;

	@ManyToOne
	private Currency paymentCurrency; // valuta placanja

	@Transient
	private String cityXML;

	@ManyToOne
	private City city;

	@OneToOne
	private DailyAccountState dailyAccountState;
	
	private String code;
	

	public AnalyticOfStatement() {
	}

	public AnalyticOfStatement(String type, String debtor, String purposeOfPayment, String creditor,
			String dateOfReceipt, String currencyDate, Integer modelAssigments, String referenceNumberAssigments,
			String debtorAccountXML, BankAccount debtorAccount, String accountCreditorXML, BankAccount accountCreditor,
			Integer modelApproval, String referenceNumberCreditor, Boolean emergency, Double sum, Integer typeOfMistake,
			String status, String paymentTypeXML, PaymentType paymentType, String paymentCurrencyXML,
			Currency paymentCurrency, String cityXML, City city, DailyAccountState dailyAccountState, String code) {
		super();
		this.type = type;
		this.debtor = debtor;
		this.purposeOfPayment = purposeOfPayment;
		this.creditor = creditor;
		this.dateOfReceipt = dateOfReceipt;
		this.currencyDate = currencyDate;
		this.modelAssigments = modelAssigments;
		this.referenceNumberAssigments = referenceNumberAssigments;
		this.debtorAccountXML = debtorAccountXML;
		this.debtorAccount = debtorAccount;
		this.accountCreditorXML = accountCreditorXML;
		this.accountCreditor = accountCreditor;
		this.modelApproval = modelApproval;
		this.referenceNumberCreditor = referenceNumberCreditor;
		this.emergency = emergency;
		this.sum = sum;
		this.typeOfMistake = typeOfMistake;
		this.status = status;
		this.paymentTypeXML = paymentTypeXML;
		this.paymentType = paymentType;
		this.paymentCurrencyXML = paymentCurrencyXML;
		this.paymentCurrency = paymentCurrency;
		this.cityXML = cityXML;
		this.city = city;
		this.dailyAccountState = dailyAccountState;
		this.code = code;
	}

	public DailyAccountState getDailyAccountState() {
		return dailyAccountState;
	}

	public void setDailyAccountState(DailyAccountState dailyAccountState) {
		this.dailyAccountState = dailyAccountState;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPaymentTypeXML() {
		return paymentTypeXML;
	}

	public void setPaymentTypeXML(String paymentTypeXML) {
		this.paymentTypeXML = paymentTypeXML;
	}

	public String getPaymentCurrencyXML() {
		return paymentCurrencyXML;
	}

	public void setPaymentCurrencyXML(String paymentCurrencyXML) {
		this.paymentCurrencyXML = paymentCurrencyXML;
	}

	public String getCityXML() {
		return cityXML;
	}

	public void setCityXML(String cityXML) {
		this.cityXML = cityXML;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDebtorAccountXML() {
		return debtorAccountXML;
	}

	public void setDebtorAccountXML(String debtorAccountXML) {
		this.debtorAccountXML = debtorAccountXML;
	}

	public void setDateOfReceipt(String dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	public void setCurrencyDate(String currencyDate) {
		this.currencyDate = currencyDate;
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

	public String getDateOfReceipt() {
		return dateOfReceipt;
	}

	public String getCurrencyDate() {
		return currencyDate;
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

	public BankAccount getAccountCreditor() {
		return accountCreditor;
	}

	public void setAccountCreditor(BankAccount accountCreditor) {
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

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
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

	public String getAccountCreditorXML() {
		return accountCreditorXML;
	}

	public void setAccountCreditorXML(String accountCreditorXML) {
		this.accountCreditorXML = accountCreditorXML;
	}


}
