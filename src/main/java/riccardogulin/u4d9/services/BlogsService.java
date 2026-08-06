package riccardogulin.u4d9.services;

import org.springframework.stereotype.Service;
import riccardogulin.u4d9.entities.Blog;
import riccardogulin.u4d9.entities.User;
import riccardogulin.u4d9.exceptions.NotFoundException;
import riccardogulin.u4d9.repositories.BlogsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BlogsService {
	private final BlogsRepository blogsRepository;
	private final UsersService usersService;

	public BlogsService(BlogsRepository blogsRepository, UsersService usersService) {
		this.blogsRepository = blogsRepository;
		this.usersService = usersService;
	}

	public List<Blog> findAll() {
		return this.blogsRepository.findAll();
	}

	public Blog save(String title, String content, String authorId) {
		// 1. Cerco l'autore tramite ID
		User userFromDB = this.usersService.findById(authorId);

		// 2. Creo l'oggetto new Blog passandogli l'autore trovato nel DB
		Blog newBlog = new Blog(title, content, userFromDB);

		// 3. Salvo
		return this.blogsRepository.save(newBlog);
	}

	public Blog findById(String blogId) {
		UUID blogIDUUID = UUID.fromString(blogId);
		return this.blogsRepository.findById(blogIDUUID).orElseThrow(() -> new NotFoundException(blogIDUUID));
	}

}
