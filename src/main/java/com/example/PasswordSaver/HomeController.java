package com.example.PasswordSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    @Autowired
    private final UserService userService;

    @Autowired
    public HomeController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/")
    public String home(Model model) {
        Set<UserEntity> users = new HashSet<>(userRepository.findAll());
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/forgotPassword")
    public String passwordRetriever() {
        return "passwordRetriever";
    }

    @PostMapping("/processForm")
    public String processForm(@RequestParam String name, @RequestParam String password) {
        // A new user entity
        UserEntity newUser = new UserEntity();
        newUser.setName(name);
        newUser.setPassword(password);

        // Save the user to the database
        userService.saveUser(newUser);

        return "success";
    }

    @GetMapping("/getUserPassword")
    public String getPasswordByName(@RequestParam String name, Model model) {
        // Find the user by name
        UserEntity user = userService.findUserByName(name);

        if (user != null) {
            // Display the user's password
            model.addAttribute("userPassword", user.getPassword());
            return "passwordRetriever"; // Display the result in the same page
        } else {
            // User not found
            return "redirect:/forgotPassword";
        }
    }

}
