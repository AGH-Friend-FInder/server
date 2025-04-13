package agh.pin.pals.server.services;

import agh.pin.pals.server.dto.CurrentPinsDTO;
import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.CurrentPinsRepository;
import agh.pin.pals.server.repositories.GroupRepository;
import agh.pin.pals.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CurrentPinsService {

    private final CurrentPinsRepository currentPinsRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public CurrentPinsService(CurrentPinsRepository currentPinsRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.currentPinsRepository = currentPinsRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;

    }

    public CurrentPins createCurrentPin(CurrentPinsDTO pinsDTO) {
        User host = userRepository.findById(pinsDTO.getHostUserId()).orElse(null);
        if (host == null) {
            return null;
        }
        List<CurrentPins> previousPins = currentPinsRepository.findCurrentPinsByHostUser(host);
        currentPinsRepository.deleteAll(previousPins);

        Long expireMinutes = pinsDTO.getExpireAtMinutes();
        Timestamp expireAt = null;

        if (expireMinutes != null) {
            LocalDateTime expireDateTime = LocalDateTime.now().plusMinutes(expireMinutes);
            expireAt = Timestamp.valueOf(expireDateTime);
        }
        CurrentPins pin = new CurrentPins(pinsDTO.getNumberOfPeople(), host, pinsDTO.getPin(), pinsDTO.getLatitude(), pinsDTO.getLongitude(), expireAt);
        currentPinsRepository.save(pin);

        for (Long group_id : pinsDTO.getGroupsId()){
            addPintoGroup(pin.getId(),group_id);
        }
        return pin;
    }

    public CurrentPins createCurrentPin(CurrentPins pin) {
        return currentPinsRepository.save(pin);
    }

    public CurrentPins getCurrentPinById(Long id) {
        return currentPinsRepository.findById(id).orElse(null);
    }

    public List<CurrentPins> getAllCurrentPins() {
        return currentPinsRepository.findAll();
    }

    public void deleteCurrentPinById(Long id) {
        currentPinsRepository.deleteById(id);
    }

    public List<CurrentPins> getVisibleCurrentPins(Long id) {
        List<CurrentPins> currentPins = currentPinsRepository.findAllPinsForUser(id);
        List<CurrentPins> resultList = new ArrayList<>();
        for (CurrentPins currentPins1 : currentPins) {
            if (!Objects.equals(currentPins1.getHostUser().getId(), id)) {
                resultList.add(currentPins1);
            }
        }
        return resultList;
    }



    public void addPintoGroup(Long pin_id, Long group_id) {
        CurrentPins pin = getCurrentPinById(pin_id);
        Group group = groupRepository.findById(group_id).orElse(null);

        if (group != null) {
            pin.getGroups().add(group);
            group.getCurrentPins().add(pin);
            currentPinsRepository.save(pin);

        }
    }
}
