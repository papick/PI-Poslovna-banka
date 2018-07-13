package poslovna_banka.xml;

import javax.xml.bind.annotation.XmlRootElement;

import poslovna_banka.model.Rtgs;

@XmlRootElement(name = "rtgs")
public class RtgsXml {

	private Long id;
	private String swiftBankFrom;
	private String accountBankForm;

	private String swiftBankTo;
	private String accountBankTo;


	private String debtor; // isplatilac-platilac-duznik-nalogodavac

	private String purposeOfPayment;

	private String creditor; // poverilac-primalac

	private String dateOfReceipt; // datum prijema

	private String currencyDate; // datum valute

	private Integer modelAssigments; // model zaduzenja

	private String referenceNumberAssigments; // poziv na broj zaduzenja

	private String debtorAccount; // racun duznika za xml

	private String accountCreditor;

	private Integer modelApproval; // model odobrenja

	private String referenceNumberCreditor; // poziv na broj odobrenja

	private Double sum;
	
	private String paymentCurrency;

	
	public RtgsXml() {
		
	}
	
	public RtgsXml(Rtgs rtgs) {
		this.id = rtgs.getId();
		this.accountBankForm = rtgs.getBankFrom().getAccountNumber();
		this.accountBankTo = rtgs.getBankTo().getAccountNumber();
		this.swiftBankFrom = rtgs.getBankFrom().getSwiftCode();
		this.swiftBankTo = rtgs.getBankTo().getSwiftCode();
		this.debtor = rtgs.getPayment().getDebtor();
		this.purposeOfPayment = rtgs.getPayment().getPurposeOfPayment();
		this.creditor = rtgs.getPayment().getCreditor();
		this.dateOfReceipt = rtgs.getPayment().getDateOfReceipt();
		this.currencyDate = rtgs.getPayment().getCurrencyDate();
		this.modelAssigments = rtgs.getPayment().getModelAssigments();
		this.referenceNumberAssigments = rtgs.getPayment().getReferenceNumberAssigments();
		this.debtorAccount = rtgs.getPayment().getDebtorAccount().getNumber();
		this.accountCreditor = rtgs.getPayment().getAccountCreditor().getNumber();
		this.modelApproval = rtgs.getPayment().getModelApproval();
		this.referenceNumberCreditor = rtgs.getPayment().getReferenceNumberCreditor();
		this.sum = rtgs.getPayment().getSum();
		this.paymentCurrency = rtgs.getPayment().getPaymentCurrency().getOfficialCode();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSwiftBankFrom() {
		return swiftBankFrom;
	}

	public void setSwiftBankFrom(String swiftBankFrom) {
		this.swiftBankFrom = swiftBankFrom;
	}

	public String getAccountBankForm() {
		return accountBankForm;
	}

	public void setAccountBankForm(String accountBankForm) {
		this.accountBankForm = accountBankForm;
	}

	public String getSwiftBankTo() {
		return swiftBankTo;
	}

	public void setSwiftBankTo(String swiftBankTo) {
		this.swiftBankTo = swiftBankTo;
	}

	public String getAccountBankTo() {
		return accountBankTo;
	}

	public void setAccountBankTo(String accountBankTo) {
		this.accountBankTo = accountBankTo;
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

	public void setDateOfReceipt(String dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	public String getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(String currencyDate) {
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

	public String getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(String debtorAccount) {
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

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}
	
	



}
