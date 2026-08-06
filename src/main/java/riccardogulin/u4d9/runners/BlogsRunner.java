package riccardogulin.u4d9.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardogulin.u4d9.entities.Blog;
import riccardogulin.u4d9.services.BlogsService;

@Component
public class BlogsRunner implements CommandLineRunner {
	private final BlogsService blogsService;

	public BlogsRunner(BlogsService blogsService) {
		this.blogsService = blogsService;
	}

	@Override
	public void run(String... args) throws Exception {
//		this.blogsService.save("PostgreSQL", "Complicato", "fd24a389-820b-4e6e-ac50-6a44b3a2ffd6");
//		this.blogsService.save("Java", "Complicatissimo", "fd24a389-820b-4e6e-ac50-6a44b3a2ffd6");

		this.blogsService.findAll().forEach(blog -> System.out.println(blog));

		Blog fromDB = this.blogsService.findById("139f395c-8dff-41fb-8d45-81ae27a45308");

		System.out.println(fromDB);
	}
}
