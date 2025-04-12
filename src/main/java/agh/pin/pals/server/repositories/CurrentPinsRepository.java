package agh.pin.pals.server.repositories;

import agh.pin.pals.server.models.CurrentPins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentPinsRepository extends JpaRepository<CurrentPins, Integer> {
}

