package riccardogulin.u4d9.services;

import org.springframework.stereotype.Service;
import riccardogulin.u4d9.entities.Blog;
import riccardogulin.u4d9.entities.BlogCategory;
import riccardogulin.u4d9.entities.Category;
import riccardogulin.u4d9.repositories.BlogsCategoriesRepository;

@Service
public class BlogsCategoriesService {

	private final BlogsCategoriesRepository blogsCategoriesRepository;
	private final CategoriesService categoriesService;
	private final BlogsService blogsService;

	public BlogsCategoriesService(BlogsCategoriesRepository blogsCategoriesRepository, CategoriesService categoriesService, BlogsService blogsService) {
		this.blogsCategoriesRepository = blogsCategoriesRepository;
		this.blogsService = blogsService;
		this.categoriesService = categoriesService;
	}


	public BlogCategory save(String blogId, String categoryId) {
		// 1. Cerco Blog By Id
		Blog blogFromDB = this.blogsService.findById(blogId);
		// 2. Cerco Category By Id
		Category categoryFromDB = this.categoriesService.findById(categoryId);

		// 3. Creo oggetto BlogCategory passandogli blog e category trovati nel DB
		BlogCategory blogCategory = new BlogCategory(blogFromDB, categoryFromDB);

		// 4. Salvo
		return this.blogsCategoriesRepository.save(blogCategory);
	}
}
