package agh.pin.pals.server.models;

import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

@Data
@Entity
@Getter
public class InvitationLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    private String link;
    private Timestamp expireAt;
}

