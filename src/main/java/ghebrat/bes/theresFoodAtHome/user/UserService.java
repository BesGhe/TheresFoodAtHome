package ghebrat.bes.theresFoodAtHome.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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


    public void updateUser(Integer userId, String firstName, String lastName, String email) throws UserException {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserException("There can only be one! This " + userId + " ain't it"));
        if(firstName != null && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }

        if(lastName != null && !Objects.equals(user.getLastName(), lastName)){
            user.setLastName(lastName);
        }

        if(email != null && !Objects.equals(user.getEmail(), email)){
            user.setEmail(email);
        }

        userRepo.save(user);
    }

    public void deleteUser(Integer userId) throws UserException {
        if(!userRepo.existsById(userId)){
            throw new UserException("They're not even there");
        }
        userRepo.deleteById(userId);
    }
}



