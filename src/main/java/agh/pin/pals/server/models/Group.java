package agh.pin.pals.server.models;

import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String groupName;
    private Boolean isPublic;
    private String color;
}

