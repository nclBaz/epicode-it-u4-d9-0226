package riccardogulin.u4d9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardogulin.u4d9.entities.User;
import riccardogulin.u4d9.exceptions.BadRequestException;
import riccardogulin.u4d9.exceptions.NotFoundException;
import riccardogulin.u4d9.repositories.UsersRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

	private final UsersRepository usersRepository;

	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public List<User> findAll() {
		return this.usersRepository.findAll();
	}

	public User save(String name, String surname, String email, String password) {
		// 1. Controlli vari...

		boolean emailInUse = this.usersRepository.findAll().stream().anyMatch(user -> user.getEmail().equals(email));
		if (emailInUse) throw new BadRequestException("L'email " + email + " è già in uso");

		User newUser = new User(name, surname, email, password);
		return this.usersRepository.save(newUser);
	}

	public User findById(String userId) {
		UUID userIdUUID = UUID.fromString(userId);
		return this.usersRepository.findById(userIdUUID).orElseThrow(() -> new NotFoundException(userIdUUID));
	}


}
