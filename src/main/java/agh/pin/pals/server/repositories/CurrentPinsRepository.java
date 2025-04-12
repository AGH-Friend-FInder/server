package agh.pin.pals.server.repositories;

import agh.pin.pals.server.models.CurrentPins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CurrentPinsRepository extends JpaRepository<CurrentPins, Integer> {
    List<CurrentPins> findByExpireAtBefore(Timestamp currentTime);

}

