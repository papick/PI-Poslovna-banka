package poslovna_banka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna_banka.model.Rtgs;
import poslovna_banka.repository.RtgsRepository;

@Service
public class RtgsService {

	@Autowired
	private RtgsRepository rtgsRepository;
	
	public Rtgs addRtgs(Rtgs rtgs) {
		return rtgsRepository.save(rtgs);
	}
}
