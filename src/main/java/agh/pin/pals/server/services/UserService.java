package agh.pin.pals.server.services;

import agh.pin.pals.server.dto.UserDTO;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
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
        if (userDTO.getEmail() != null) {
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

