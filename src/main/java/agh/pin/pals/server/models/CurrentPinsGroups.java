package agh.pin.pals.server.models;

import jakarta.persistence.*;

@Entity
@Table(name = "current_pins_groups")
@IdClass(CurrentPinsGroupsId.class)
public class CurrentPinsGroups {

    @Id
    @ManyToOne
    @JoinColumn(name = "current_pins_id")
    private CurrentPins currentPin;

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}

