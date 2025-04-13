package agh.pin.pals.server.models;

import agh.pin.pals.server.dto.CurrentPinsDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
public class CurrentPins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numberOfPeople;

    @ManyToMany
    @JoinTable(
            name = "current_pins_groups",
            joinColumns = @JoinColumn(name = "current_pins_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @JsonBackReference
    private List<Group> groups;

    @ManyToOne
    @JoinColumn(name = "host_user_id", referencedColumnName = "id")
    @JsonBackReference
    private User hostUser;

    private String pin;
    private Float latitude;
    private Float longitude;

    private Timestamp expireAt;


    public CurrentPins() {

    }

    public CurrentPins(Long numberOfPeople,User hostUser, String pin, Float latitude, Float longitude, Timestamp expireAt) {
        this.numberOfPeople = numberOfPeople;
        this.hostUser = hostUser;
        this.pin = pin;
        this.latitude = latitude;
        this.longitude = longitude;
        this.expireAt = expireAt;
        this.groups = new ArrayList<>();
    }
}

