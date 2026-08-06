package riccardogulin.u4d9.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "blogs_categories")
@ToString
@Getter
@Setter
public class BlogCategory {

	@Id
	@GeneratedValue
	@Setter(AccessLevel.NONE)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "blog_id", nullable = false)
	private Blog blog;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Column(nullable = false)
	private LocalDate date;

	public BlogCategory() {
	}

	public BlogCategory(Blog blog, Category category) {
		this.blog = blog;
		this.category = category;
		this.date = LocalDate.now();
	}
}
