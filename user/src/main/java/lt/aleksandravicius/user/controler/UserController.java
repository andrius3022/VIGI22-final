package lt.aleksandravicius.user.controler;

import lt.aleksandravicius.user.dto.User;
import lt.aleksandravicius.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class UserController {


    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }


    //Handler method to get list of all users
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/users/new")
    public String createUser(Model model) {
        User user = new User(); //creating user object to hold data
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";

    }

    //Update user info
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user, Model model) {

        //get user info from db by id
        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setCountry(user.getCountry());
        existingUser.setServer(user.getServer());

        //save new info into user
        userService.updateUser(existingUser);
        return "redirect:/users";

    }

    //method to delete user
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
