package poslovna_banka.service.dto;

public class ReportDTO {

	private String bankAccount;

	private String from;

	private String to;
	
	public ReportDTO() {
		
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public ReportDTO(String bankAccount, String from, String to) {
		super();
		this.bankAccount = bankAccount;
		this.from = from;
		this.to = to;
	}
	
}
