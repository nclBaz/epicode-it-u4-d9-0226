package riccardogulin.u4d9.services;

import org.springframework.stereotype.Service;
import riccardogulin.u4d9.entities.Theme;
import riccardogulin.u4d9.entities.User;
import riccardogulin.u4d9.entities.UserSettings;
import riccardogulin.u4d9.repositories.UserSettingsRepository;

@Service
public class UserSettingsService {

	private final UserSettingsRepository userSettingsRepository;
	private final UsersService usersService;

	public UserSettingsService(UserSettingsRepository userSettingsRepository, UsersService usersService) {
		this.userSettingsRepository = userSettingsRepository;
		this.usersService = usersService;
	}

	public UserSettings save(Theme theme, boolean notificationsEnabled, String userId) {

//		// 1. Cerchiamo l'utente tramite id
		User userFromDB = this.usersService.findById(userId);
		// User newUser = new User("Aldo", "Baglio", "", ""); // <-- TRANSIENT NON HA UN ID!

		// 2. Creiamo l'oggetto UserSettings (passandogli lo user trovato)
//		UserSettings settings = new UserSettings(notificationsEnabled, theme, newUser); // con newUser non funziona perché é TRANSIENT
		UserSettings settings = new UserSettings(notificationsEnabled, theme, userFromDB);

		// 3. Salvo i settings (JPA imposterà la FK prendendola dallo user trovato)
		return this.userSettingsRepository.save(settings);

	}
	
//	public UserSettings findByIdAndUpdate(String settingsId, Theme theme, boolean notificationsEnabled){}

}
