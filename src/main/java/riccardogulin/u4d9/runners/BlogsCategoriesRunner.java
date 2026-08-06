package riccardogulin.u4d9.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardogulin.u4d9.services.BlogsCategoriesService;

@Component
public class BlogsCategoriesRunner implements CommandLineRunner {
	private final BlogsCategoriesService blogsCategoriesService;

	public BlogsCategoriesRunner(BlogsCategoriesService blogsCategoriesService) {
		this.blogsCategoriesService = blogsCategoriesService;
	}

	@Override
	public void run(String... args) throws Exception {

		blogsCategoriesService.save("139f395c-8dff-41fb-8d45-81ae27a45308", "2950e39a-fa1d-4075-93f1-e30280265b92");
		blogsCategoriesService.save("139f395c-8dff-41fb-8d45-81ae27a45308", "33e601d6-5d7f-4155-99e4-6d295d567b96");
	}
}
