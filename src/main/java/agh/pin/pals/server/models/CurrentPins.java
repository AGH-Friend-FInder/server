package agh.pin.pals.server.models;

import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

@Data
@Entity
@Getter
public class CurrentPins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "host_user_id", referencedColumnName = "id")
    private User hostUser;

    private String pin;
    private Float latitude;
    private Float longitude;

    private Timestamp expireAt;
}

