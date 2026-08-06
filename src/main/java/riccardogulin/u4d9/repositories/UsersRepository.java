package riccardogulin.u4d9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u4d9.entities.User;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID> {
}
