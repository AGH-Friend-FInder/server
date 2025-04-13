package agh.pin.pals.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Data
@Entity
@Getter
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private Boolean isPublic;
    private String color;
    @ManyToMany(mappedBy = "groups")
    @JsonBackReference
    private List<CurrentPins> currentPins;
    @ManyToMany(mappedBy = "groups")
    @JsonBackReference
    private List<User> users;
}

