package agh.pin.pals.server.dto;

import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.User;

import java.sql.Timestamp;
import java.util.List;

public class CurrentPinsDTO {
    private Integer numberOfPeople;
    private User hostUser;

    private String pin;
    private Float latitude;
    private Float longitude;

    private Timestamp expireAt;

    private List<Integer> groups;


    public CurrentPinsDTO() {};

}
