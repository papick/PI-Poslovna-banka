package poslovna_banka.resource;

import javax.servlet.http.HttpServletRequest;

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
	public ResponseEntity<LogInResponse> logIn(@RequestBody UserDTO userDTO, HttpServletRequest request) {

		Bank bank = userService.logIn(userDTO);
		request.getSession().setMaxInactiveInterval(60*60*12);
		request.getSession().setAttribute("bank", bank);
		return new ResponseEntity<>(new LogInResponse(bank), HttpStatus.OK);
	}
}
