package riccardogulin.u4d9.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "categories")
@ToString
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue
	@Setter(AccessLevel.NONE)
	private UUID id;

	@Column(nullable = false)
	private String name;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

}
