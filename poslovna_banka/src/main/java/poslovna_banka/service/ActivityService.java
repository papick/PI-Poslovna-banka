package poslovna_banka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poslovna_banka.model.Activity;
import poslovna_banka.repository.ActivityRepository;
import poslovna_banka.service.dto.CountryDTO;

@Transactional
@Service
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	public Activity addActivity(CountryDTO countryDTO) {

		Activity activity = new Activity();

		activity.setCode(countryDTO.getCode());
		activity.setName(countryDTO.getName());

		activityRepository.save(activity);

		return activity;

	}

	public Activity editActivity(Long id, CountryDTO countryDTO) {

		Activity activity = activityRepository.findOne(id);

		activity.setCode(countryDTO.getCode());
		activity.setName(countryDTO.getName());

		activityRepository.save(activity);

		return activity;
	}

	public Activity delete(Long id) {
		Activity activity = activityRepository.findOne(id);
		if (activity == null) {
			throw new IllegalArgumentException("Tried to delete" + "non-existant activity");
		}

		activityRepository.delete(activity);
		return activity;
	}

}
