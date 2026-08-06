package riccardogulin.u4d9.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "user_settings")
@ToString
@Getter
@Setter
public class UserSettings {

	@Id
	@GeneratedValue
	@Setter(AccessLevel.NONE)
	private UUID id;

	@Column(nullable = false, name = "notifications_enabled")
	private boolean notificationsEnabled;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Theme theme;


	// FK
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	@Setter(AccessLevel.NONE)
	private User user;


	public UserSettings() {
	}

	public UserSettings(boolean notificationsEnabled, Theme theme, User user) {
		this.notificationsEnabled = notificationsEnabled;
		this.theme = theme;
		this.user = user;
	}

}
