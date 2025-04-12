package agh.pin.pals.server.repositories;

import agh.pin.pals.server.models.CurrentPins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CurrentPinsRepository extends JpaRepository<CurrentPins, Integer> {
    List<CurrentPins> findByExpireAtBefore(Timestamp currentTime);


    @Query("SELECT DISTINCT cp FROM CurrentPins cp " +
            "JOIN cp.groups g " +
            "JOIN g.users u " +
            "WHERE u.id = :userId")
    List<CurrentPins> findAllPinsForUser(@Param("userId") Integer userId);


}

