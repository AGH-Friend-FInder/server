package agh.pin.pals.server.dto;

import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
@Data
public class CurrentPinsDTO {
    private Integer numberOfPeople;
    private Integer hostUserId;

    private String pin;
    private Float latitude;
    private Float longitude;

    private Integer expireAtMinutes;

    private List<Integer> groupsId;


    public CurrentPinsDTO() {};

}
