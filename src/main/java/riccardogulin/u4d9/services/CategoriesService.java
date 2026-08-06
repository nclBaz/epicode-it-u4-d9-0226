package riccardogulin.u4d9.services;

import org.springframework.stereotype.Service;
import riccardogulin.u4d9.entities.Category;
import riccardogulin.u4d9.exceptions.NotFoundException;
import riccardogulin.u4d9.repositories.CategoriesRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriesService {
	private final CategoriesRepository categoriesRepository;

	public CategoriesService(CategoriesRepository categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	public Category save(String name) {
		// 1. TODO: controlla che non esista già

		// 2. Creiamo la categoria e la salviamo
		Category newCategory = new Category(name);

		return this.categoriesRepository.save(newCategory);
	}

	public Category findById(String categoryId) {
		UUID categoryIdUUID = UUID.fromString(categoryId);
		return this.categoriesRepository.findById(categoryIdUUID).orElseThrow(() -> new NotFoundException(categoryIdUUID));
	}

	public List<Category> findAll() {
		return this.categoriesRepository.findAll();
	}
}
