package agh.pin.pals.server.controllers;

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
    @PostMapping
    public CurrentPins createGroup(@RequestBody CurrentPins currentPins) {
        return currentPinsService.createCurrentPin(currentPins);
    }

    @GetMapping("/{id}")
    public CurrentPins getCurrentPinById(@PathVariable Integer id) {
        return currentPinsService.getCurrentPinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrentPinById(@PathVariable Integer id) {
        currentPinsService.deleteCurrentPinById(id);
    }

    @GetMapping("/visible/{id}")
    public List<CurrentPins> getVisibleCurrentPins(@PathVariable Integer id) {
        return currentPinsService.getVisibleCurrentPins(id);


    }
}

