package riccardogulin.u4d9.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardogulin.u4d9.entities.Theme;
import riccardogulin.u4d9.exceptions.NotFoundException;
import riccardogulin.u4d9.services.UserSettingsService;

@Component
public class SettingsRunner implements CommandLineRunner {

	private UserSettingsService userSettingsService;

	public SettingsRunner(UserSettingsService settingsService) {
		this.userSettingsService = settingsService;
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			this.userSettingsService.save(Theme.DARK, false, "fd24a389-820b-4e6e-ac50-6a44b3a2ffd5");
		} catch (NotFoundException ex) {
			System.out.println(ex.getMessage());

		}


	}
}
