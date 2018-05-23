package poslovna_banka.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.Activity;
import poslovna_banka.repository.ActivityRepository;
import poslovna_banka.resource.response.ResponseActivities;
import poslovna_banka.service.ActivityService;
import poslovna_banka.service.dto.CountryDTO;

@RestController
@RequestMapping(value = "/api/activities")
public class ActivityResource {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActivityService activityService;

	@GetMapping("/get-activities")
	public ResponseEntity<ResponseActivities> getActivities() {

		ArrayList<Activity> activity = (ArrayList<Activity>) activityRepository.findAll();

		return new ResponseEntity<>(new ResponseActivities(activity), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Activity> getCountry(@PathVariable Long id) {
		Activity activity = activityRepository.findOne(id);
		if (activity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(activity, HttpStatus.OK);
	}

	@PostMapping("/add-activity")
	public ResponseEntity<Activity> addActivity(@RequestBody CountryDTO countryDTO) {

		Activity activity = activityService.addActivity(countryDTO);
		return new ResponseEntity<Activity>(activity, HttpStatus.OK);
	}

	@DeleteMapping("/delete-activity/{id}")
	public ResponseEntity<Activity> delete(@PathVariable Long id) {

		Activity deleted = activityService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@PutMapping("/edit-activity/{id}")
	public ResponseEntity<Activity> editCity(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {

		Activity activity = activityService.editActivity(id, countryDTO);
		return new ResponseEntity<>(activity, HttpStatus.OK);

	}

}
