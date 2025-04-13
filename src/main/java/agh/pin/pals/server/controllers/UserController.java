package agh.pin.pals.server.controllers;

import agh.pin.pals.server.dto.UserDTO;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.GroupRepository;
import agh.pin.pals.server.repositories.UserRepository;
import agh.pin.pals.server.services.GroupService;
import agh.pin.pals.server.services.GroupService;
import agh.pin.pals.server.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, GroupRepository groupRepository) {
        this.userService = userService;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Creating user: " + user.getId());
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info("Getting user: " + id);
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO) {
        logger.info("Registering user: " + userDTO.getUsername());
        try {
            User createdUser = userService.createUser(userDTO);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody UserDTO userDTO) {
        logger.info("Logging user: " + userDTO.getUsername());
        try {
            User user = userService.loginUser(userDTO);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }

    @PostMapping("/{user_id}/{group_id}")
    public ResponseEntity<Object> addUserToGroup(@PathVariable Long user_id, @PathVariable Long group_id) {
        logger.info("Adding user: " + user_id + " to group: " + group_id);
        try {
            User user = userService.addUserToGroup(user_id,group_id);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }

    @DeleteMapping("/{user_id}/{group_id}")
    public void deleteUserFromGroup(@PathVariable Long user_id, @PathVariable Long group_id) {
        logger.info("Deleting user: " + user_id + " from group: " + group_id);
        userService.removeUserFromGroup(user_id,group_id);
    }

    @GetMapping("/group/{id}")
    public List<Group> getUserGroups(@PathVariable Long id) {
        logger.info("Getting groups for user: " + id);
        return userService.getUserGroups(id);
    }


}

