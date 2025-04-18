package agh.pin.pals.server.controllers;

import agh.pin.pals.server.dto.UserDTO;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.UserRepository;
import agh.pin.pals.server.services.GroupService;
import agh.pin.pals.server.services.GroupService;
import agh.pin.pals.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            User createdUser = userService.createUser(userDTO);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            User user = userService.loginUser(userDTO);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }

    @PostMapping("/{user_id}/{group_id}")
    public User addUserToGroup(@PathVariable Integer user_id, @PathVariable Integer group_id) {
        return userService.addUserToGroup(user_id,group_id);
    }
    @DeleteMapping("/{user_id}/{group_id}")
    public void deleteUserFromGroup(@PathVariable Integer user_id, @PathVariable Integer group_id) {
        userService.removeUserFromGroup(user_id,group_id);
    }

    @GetMapping("/group/{id}")
    public List<Group> getUserGroups(@PathVariable Integer id) {
        return userService.getUserGroups(id);
    }


}

