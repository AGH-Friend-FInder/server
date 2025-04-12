package agh.pin.pals.server.services;

import agh.pin.pals.server.models.UserGroup;
import agh.pin.pals.server.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    @Autowired
    public UserGroupService(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    public UserGroup createUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public UserGroup getUserGroupById(Integer id) {
        return userGroupRepository.findById(id).orElse(null);
    }
}
