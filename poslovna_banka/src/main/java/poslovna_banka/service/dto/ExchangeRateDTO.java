package poslovna_banka.service.dto;

public class ExchangeRateDTO {
	
	private long idBank;
	

	
	private String appliedFrom;
	
	public ExchangeRateDTO() {
		// TODO Auto-generated constructor stub
	}

	public ExchangeRateDTO(long idBank,  String appliedFrom) {
		super();
		this.idBank = idBank;
		this.appliedFrom = appliedFrom;
	}

	public long getIdBank() {
		return idBank;
	}

	public void setIdBank(long idBank) {
		this.idBank = idBank;
	}

	

	public String getAppliedFrom() {
		return appliedFrom;
	}

	public void setAppliedFrom(String appliedFrom) {
		this.appliedFrom = appliedFrom;
	}
	
	
	
	
	

}
