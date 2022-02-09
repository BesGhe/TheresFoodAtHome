package ghebrat.bes.theresFoodAtHome.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> showUsers(){
        return userService.showUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) throws UserException {
        userService.addUser(user);
    }
}
