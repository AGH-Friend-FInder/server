package agh.pin.pals.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Getter
public class CurrentPins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfPeople;

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
}

