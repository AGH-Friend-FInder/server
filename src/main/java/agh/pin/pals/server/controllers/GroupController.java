package agh.pin.pals.server.controllers;

import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.repositories.GroupRepository;
import agh.pin.pals.server.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupService groupService, GroupRepository groupRepository) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);
    }

    @GetMapping("/public")
    public List<Group> getPublicGroup() {
        return groupRepository.findByIsPublicTrue();
    }



}

