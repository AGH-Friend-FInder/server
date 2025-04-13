package agh.pin.pals.server.controllers;

import agh.pin.pals.server.dto.CurrentPinsDTO;
import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.services.CurrentPinsService;
import agh.pin.pals.server.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pin")
public class CurrentPinsController {

    private static final Logger logger = LoggerFactory.getLogger(CurrentPinsController.class);
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
        logger.info("Creatign pin: " + currentPinsDTO.getPin());
        return currentPinsService.createCurrentPin(currentPinsDTO);
    }

    @GetMapping("/{id}")
    public CurrentPins getCurrentPinById(@PathVariable Long id) {
        logger.info("Getting pin: " + id);
        return currentPinsService.getCurrentPinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrentPinById(@PathVariable Long id) {
        logger.info("Deleting pin: " + id);
        currentPinsService.deleteCurrentPinById(id);
    }

    @GetMapping("/visible/{id}")
    public List<CurrentPinsDTO> getVisibleCurrentPins(@PathVariable Long id) {
        logger.info("Getting visible pins: " + id);
        List<CurrentPins> currentPins = currentPinsService.getVisibleCurrentPins(id);
        List<CurrentPinsDTO> currentPinsDTOS = new ArrayList<>();
        for (CurrentPins currentPin : currentPins) {
            currentPinsDTOS.add(new CurrentPinsDTO(currentPin));
        }
        return currentPinsDTOS;
    }






}

