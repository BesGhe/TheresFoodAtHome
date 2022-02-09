package ghebrat.bes.theresFoodAtHome.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User> showUsers() {
        return userRepo.findAll();
    }


    public void addUser(User user) throws UserException {
        if (!userRepo.findByEmail(user.getEmail()).isPresent()) {
            userRepo.save(user);
        } else throw new UserException("User with" + user.getEmail() + "already exists");
    }

}



