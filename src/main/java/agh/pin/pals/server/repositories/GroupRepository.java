package agh.pin.pals.server.repositories;

import agh.pin.pals.server.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}

