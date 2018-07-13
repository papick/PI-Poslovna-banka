package poslovna_banka.xml;


import poslovna_banka.model.AnalyticOfStatement;

public class AnalyticXml {
	
	private Long id;
	
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

	public AnalyticXml () {}
	
	public AnalyticXml(AnalyticOfStatement analytic) {
		this.setId(analytic.getId());
		this.debtor = analytic.getDebtor();
		this.purposeOfPayment = analytic.getPurposeOfPayment();
		this.creditor = analytic.getCreditor();
		this.dateOfReceipt = analytic.getDateOfReceipt();
		this.currencyDate = analytic.getCurrencyDate();
		this.modelAssigments = analytic.getModelAssigments();
		this.referenceNumberAssigments = analytic.getReferenceNumberAssigments();
		this.debtorAccount = analytic.getDebtorAccount().getNumber();
		this.accountCreditor = analytic.getAccountCreditor().getNumber();
		this.modelApproval = analytic.getModelApproval();
		this.referenceNumberCreditor = analytic.getReferenceNumberCreditor();
		this.sum = analytic.getSum();
		this.paymentCurrency = analytic.getPaymentCurrency().getOfficialCode();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
