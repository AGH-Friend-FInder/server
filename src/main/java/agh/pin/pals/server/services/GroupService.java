package agh.pin.pals.server.services;

import agh.pin.pals.server.dto.GroupDTO;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import agh.pin.pals.server.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserService userService;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserService userService) {
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    public Group createGroup(GroupDTO groupDTO) {
        Group potentialGroup = groupRepository.findByGroupName();
        if (potentialGroup != null) {
            throw new IllegalArgumentException("Group already exists");
        }
        Group group = new Group();
        group.setGroupName(groupDTO.getGroupName());
        group.setIsPublic(groupDTO.getIsPublic());
        group.setColor(groupDTO.getColor());
        userService.addUserToGroup(groupDTO.getUserId(), group.getId());
        return groupRepository.save(group);
    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }
}

