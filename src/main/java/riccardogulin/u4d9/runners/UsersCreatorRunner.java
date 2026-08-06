package riccardogulin.u4d9.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardogulin.u4d9.services.UsersService;

@Component
public class UsersCreatorRunner implements CommandLineRunner {

	private final UsersService usersService;

	public UsersCreatorRunner(UsersService usersService) {
		this.usersService = usersService;
	}


	@Override
	public void run(String... args) throws Exception {

		// usersService.save("Aldo", "Baglio", "aldo@gmail.com", "1234");

	}
}
