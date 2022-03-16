package ghebrat.bes.theresFoodAtHome.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class UserConfig {


    CommandLineRunner commandLineRunner (UserRepo userRepo){
        return args -> {
            User bes = new User( "Bes", "Yellow", "realemail@email.com");
            bes.setId(1);
            userRepo.save(bes);
        };
    }

}
