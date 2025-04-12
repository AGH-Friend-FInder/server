package agh.pin.pals.server.services;

import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group getGroupById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }
}

