package agh.pin.pals.server.controllers;


import agh.pin.pals.server.models.UserGroup;
import agh.pin.pals.server.services.UserGroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adduser")
public class UserGroupController {
    private final UserGroupService userGroupService;

    public UserGroupController(final UserGroupService userGroupService)
    {
        this.userGroupService = userGroupService;
    }

    @PostMapping
    public UserGroup addUserToGroup(@RequestBody UserGroup userGroup) {
        return userGroupService.createUserGroup(userGroup);
    }
    
}
