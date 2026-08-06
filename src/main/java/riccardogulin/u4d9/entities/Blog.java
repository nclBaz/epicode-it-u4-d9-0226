package riccardogulin.u4d9.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "blogs")
@ToString
@Getter
@Setter
public class Blog {

	@Id
	@GeneratedValue
	@Setter(AccessLevel.NONE)
	private UUID id;

	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	@Column(name = "publish_date", nullable = false)
	private LocalDate publishDate;

	// FK
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User author;

	public Blog() {
	}

	public Blog(String title, String content, User author) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.publishDate = LocalDate.now();
	}
}
