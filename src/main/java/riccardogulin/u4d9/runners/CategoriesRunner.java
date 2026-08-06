package riccardogulin.u4d9.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardogulin.u4d9.services.CategoriesService;

@Component
public class CategoriesRunner implements CommandLineRunner {

	private final CategoriesService categoriesService;

	public CategoriesRunner(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	@Override
	public void run(String... args) throws Exception {
		categoriesService.save("Backend");
		categoriesService.save("OOP");
		categoriesService.save("Databases");
		categoriesService.save("Programmazione");
	}
}
