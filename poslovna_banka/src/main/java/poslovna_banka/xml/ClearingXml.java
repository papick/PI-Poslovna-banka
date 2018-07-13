package poslovna_banka.xml;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import poslovna_banka.model.Clearing;

@XmlRootElement(name = "clearing")

public class ClearingXml {

	private Long id;
	private String swiftBankFrom;
	private String accountBankForm;

	private String swiftBankTo;
	private String accountBankTo;
	
	private double sumAll;
	private String currency;
	private String currencyDate;
	
	private List<AnalyticXml> payments;
	
	public ClearingXml() {
		
	}
	
	public ClearingXml(Clearing clearing) {
		this.id = clearing.getId();
		this.accountBankForm = clearing.getBankFrom().getAccountNumber();
		this.accountBankTo = clearing.getBankTo().getAccountNumber();
		this.swiftBankFrom = clearing.getBankFrom().getSwiftCode();
		this.swiftBankTo = clearing.getBankTo().getSwiftCode();
		this.sumAll = clearing.getSumAll();
		this.currency = clearing.getCurrency().getOfficialCode();
		this.currencyDate = clearing.getDateOfCurrency();
		this.payments = clearing.getPayments().stream().map( a -> new AnalyticXml(a)).collect(Collectors.toList());
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

	@XmlElementWrapper
	@XmlElement(name="payment")
	public List<AnalyticXml> getPayments() {
		return payments;
	}

	public void setPayments(List<AnalyticXml> payments) {
		this.payments = payments;
	}

	public double getSumAll() {
		return sumAll;
	}

	public void setSumAll(double sumAll) {
		this.sumAll = sumAll;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(String currencyDate) {
		this.currencyDate = currencyDate;
	}
	
	
	
	
	
}
