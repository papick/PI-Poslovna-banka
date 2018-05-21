package poslovna_banka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poslovna_banka.model.Bank;
import poslovna_banka.model.User;
import poslovna_banka.repository.UserRepository;
import poslovna_banka.service.dto.UserDTO;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Bank logIn(UserDTO userDTO) {

		User user = userRepository.findOneByUsername(userDTO.getUsername());
		if (user == null) {
			throw new IllegalArgumentException("User not found!");
		}

		if (user.getPassword().equals(userDTO.getPassword())) {
			Bank bank = user.getBank();
			return bank;
		}

		return null;
	}
}
