package org.example.fines_api.controller;

import org.example.fines_api.entity.User;
import org.example.fines_api.service.ManageDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ManageDataService manageDataService;

    public UserController(ManageDataService manageDataService) {
        this.manageDataService = manageDataService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return manageDataService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return manageDataService.getUserById(userId);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return manageDataService.addUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId) {
        user.setId(userId);
        return manageDataService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        manageDataService.deleteUserById(userId);
    }
}
