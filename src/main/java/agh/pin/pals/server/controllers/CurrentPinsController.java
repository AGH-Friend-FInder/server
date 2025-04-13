package agh.pin.pals.server.controllers;

import agh.pin.pals.server.dto.CurrentPinsDTO;
import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.services.CurrentPinsService;
import agh.pin.pals.server.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pin")
public class CurrentPinsController {

    private final CurrentPinsService currentPinsService;

    @Autowired
    public CurrentPinsController(final CurrentPinsService currentPinsService) {
        this.currentPinsService = currentPinsService;
    }
//    @PostMapping
//    public CurrentPins createCurrenPins(@RequestBody CurrentPins currentPins) {
//        return currentPinsService.createCurrentPin(currentPins);
//    }

    @PostMapping()
    public CurrentPins createCurrentPin(@RequestBody final CurrentPinsDTO currentPinsDTO) {
        return currentPinsService.createCurrentPin(currentPinsDTO);
    }

    @GetMapping("/{id}")
    public CurrentPins getCurrentPinById(@PathVariable Long id) {
        return currentPinsService.getCurrentPinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrentPinById(@PathVariable Long id) {
        currentPinsService.deleteCurrentPinById(id);
    }

    @GetMapping("/visible/{id}")
    public List<CurrentPins> getVisibleCurrentPins(@PathVariable Long id) {
        return currentPinsService.getVisibleCurrentPins(id);
    }






}

