package agh.pin.pals.server.repositories;

import agh.pin.pals.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    User findUserByEmail(String email);
    User findUserByUsername(String username);


}

