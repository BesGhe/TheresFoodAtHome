package ghebrat.bes.theresFoodAtHome.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

    Optional<Item> findByName (String name);
    Optional<Item> findById (Long id);

}
