package agh.pin.pals.server.repositories;

import agh.pin.pals.server.models.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}

