package agh.pin.pals.server.controllers;

import agh.pin.pals.server.dto.GroupDTO;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.repositories.GroupRepository;
import agh.pin.pals.server.services.GroupService;
import agh.pin.pals.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

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
    public Group createGroup(@RequestBody GroupDTO groupDTO) {
        Group group = new Group();
        group.setGroupName(groupDTO.getGroupName());
        group.setIsPublic(groupDTO.getIsPublic());
        group.setColor(groupDTO.getColor());
        userService.addUserToGroup(groupDTO.getUserId(), group.getId());
        return groupService.createGroup(group);
    }


    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @GetMapping("/public")
    public List<Group> getPublicGroup() {
        return groupRepository.findByIsPublicTrue();
    }



}

