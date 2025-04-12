package agh.pin.pals.server.services;

import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.repositories.CurrentPinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentPinsService {

    private final CurrentPinsRepository currentPinsRepository;

    @Autowired
    public CurrentPinsService(CurrentPinsRepository currentPinsRepository) {
        this.currentPinsRepository = currentPinsRepository;
    }

    public CurrentPins createCurrentPin(CurrentPins currentPin) {
        return currentPinsRepository.save(currentPin);
    }

    public CurrentPins getCurrentPinById(Integer id) {
        return currentPinsRepository.findById(id).orElse(null);
    }

    public List<CurrentPins> getAllCurrentPins() {
        return currentPinsRepository.findAll();
    }

    public void deleteCurrentPinById(Integer id) {
        currentPinsRepository.deleteById(id);
    }

//    public List<CurrentPins> getVisibleCurrentPins(Integer id) {
//
//    }
}
