package poslovna_banka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.Bank;
import poslovna_banka.resource.response.LogInResponse;
import poslovna_banka.service.UserService;
import poslovna_banka.service.dto.UserDTO;

@RestController
@RequestMapping(value = "/api/user")
public class UserResource {

	@Autowired
	private UserService userService;

	@PutMapping("/log-in")
	public ResponseEntity<LogInResponse> logIn(@RequestBody UserDTO userDTO) {

		Bank bank = userService.logIn(userDTO);

		return new ResponseEntity<>(new LogInResponse(bank), HttpStatus.OK);
	}
}
