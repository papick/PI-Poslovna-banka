package poslovna_banka.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String number;
	
	@NotNull
	private Date dateOfOpenning;
	
	private boolean valid;
	
	@ManyToOne
	private Bank bank;
	
	private Individual individual;
	
	private LegalEntity legalEntity;
}
