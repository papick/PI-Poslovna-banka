package poslovna_banka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poslovna_banka.model.PaymentType;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {
	PaymentType findOneByCode(String code);

}
