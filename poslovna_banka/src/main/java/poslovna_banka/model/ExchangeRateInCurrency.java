package poslovna_banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ExchangeRateInCurrency")
public class ExchangeRateInCurrency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private float buying;
	
	@Column
	private float middle;
	
	@Column
	private float selling;
	
	
	
	

}
