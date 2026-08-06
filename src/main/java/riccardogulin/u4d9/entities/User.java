package riccardogulin.u4d9.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue // Non mettiamo IDENTITY perché è la strategia per i serial
	@Setter(AccessLevel.NONE)
	private UUID userId;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(name = "avatar_url", nullable = false)
	@Setter(AccessLevel.NONE)
	private String avatarUrl;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	public User() {
	}

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = Role.USER;
		this.avatarUrl = "https://picsum.photos/200/300";
	}
}
