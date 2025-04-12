package agh.pin.pals.server.services;

import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.repositories.CurrentPinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CurrentPinCleanupService {

    private final CurrentPinsRepository currentPinsRepository;

    @Autowired
    public CurrentPinCleanupService(CurrentPinsRepository currentPinsRepository) {
        this.currentPinsRepository = currentPinsRepository;
    }

    @Scheduled(fixedRate = 900000)
    public void removeExpiredPins() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        List<CurrentPins> expiredPins = currentPinsRepository.findByExpireAtBefore(currentTime);
        currentPinsRepository.deleteAll(expiredPins);
        System.out.println("Removed expired pins: " + expiredPins.size());
    }
}
