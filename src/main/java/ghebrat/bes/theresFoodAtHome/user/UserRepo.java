package ghebrat.bes.theresFoodAtHome.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
