package agh.pin.pals.server.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_groups")
@IdClass(UserGroupId.class)
public class UserGroup {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}

