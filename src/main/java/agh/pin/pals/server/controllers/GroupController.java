package agh.pin.pals.server.controllers;

import agh.pin.pals.server.dto.GroupDTO;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.GroupRepository;
import agh.pin.pals.server.services.GroupService;
import agh.pin.pals.server.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private final GroupService groupService;
    private final UserService userService;
    private final GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupService groupService, GroupRepository groupRepository, UserService userService) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createGroup(@RequestBody GroupDTO groupDTO) {
        logger.info("Creating group: " + groupDTO.getGroupName());
        try {
            Group group = groupService.createGroup(groupDTO);
            return ResponseEntity.ok(group);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id) {
        logger.info("Getting group: " + id);
        return groupService.getGroupById(id);
    }

    @GetMapping("/public")
    public List<Group> getPublicGroup() {
        logger.info("Creating public groups");
        return groupRepository.findByIsPublicTrue();
    }



}

