package poslovna_banka.resource.response;

import poslovna_banka.model.Bank;

public class LogInResponse {

	private Bank bank;

	public LogInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogInResponse(Bank bank) {
		super();
		this.bank = bank;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
