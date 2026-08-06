package riccardogulin.u4d9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u4d9.entities.BlogCategory;

import java.util.UUID;

@Repository
public interface BlogsCategoriesRepository extends JpaRepository<BlogCategory, UUID> {
}
