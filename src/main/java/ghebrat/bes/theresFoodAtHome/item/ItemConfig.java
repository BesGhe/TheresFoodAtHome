package ghebrat.bes.theresFoodAtHome.item;


import ghebrat.bes.theresFoodAtHome.user.UserConfig;
import ghebrat.bes.theresFoodAtHome.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Autowired
    public UserRepo userRepo;

    public ItemConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Bean
    CommandLineRunner commandLineRunner (ItemRepo itemRepo){
        return args -> {
            itemRepo.save(new Item("chicken", "poultry", "freezer"));
            itemRepo.save(new Item("orange juice", "drink", "fridge"));
            itemRepo.save(new Item("potatoes", "vegetable", "cabinet"));
        };
    }
}
