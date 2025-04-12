package agh.pin.pals.server.services;

import agh.pin.pals.server.dto.UserDTO;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.GroupRepository;
import agh.pin.pals.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public UserService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUserToGroup(Integer user_id, Integer group_id) {
        User user = getUserById(user_id);
        Group group = groupRepository.findById(group_id).orElse(null);

        if (group != null) {
            user.getGroups().add(group);
            group.getUsers().add(user);
            userRepository.save(user);

        }
        return user;
    }

    public void removeUserFromGroup(Integer user_id, Integer group_id) {
        User user = getUserById(user_id);
        Group group = groupRepository.findById(group_id).orElse(null);
        if (group != null) {
            user.getGroups().remove(group);
            group.getUsers().remove(user);
            userRepository.save(user);
        }
    }

    public User createUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new IllegalArgumentException("Username is already in use");
        }
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    public User loginUser(UserDTO userDTO) {
        if (userDTO == null) throw new IllegalArgumentException("No user information");
        if (userDTO.getEmail() == null && userDTO.getUsername() == null) throw new IllegalArgumentException("Provide login or email");
        User user;
        if (userDTO.getEmail() != null && !userDTO.getEmail().isBlank()) {
            user = userRepository.findUserByEmail(userDTO.getEmail());
            if (user == null) {
                throw new IllegalArgumentException("Invalid email");
            }
        } else {
            user = userRepository.findUserByUsername(userDTO.getUsername());
            if (user == null) {
                throw new IllegalArgumentException("Invalid username");
            }
        }

        if (!user.getPassword().equals(userDTO.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials.");
        }
        return user;
    }
}

