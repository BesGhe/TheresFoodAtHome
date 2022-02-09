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

    @PutMapping("/{userId}")
    public void UpdateUser(@PathVariable Integer userId,
                           @RequestParam(required = false) String firstName,
                           @RequestParam(required = false) String lastName,
                           @RequestParam(required = false) String email) throws UserException {

        userService.updateUser(userId, firstName, lastName, email);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) throws UserException {
        userService.deleteUser(userId);
    }

}
