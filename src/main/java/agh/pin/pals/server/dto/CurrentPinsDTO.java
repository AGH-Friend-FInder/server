package agh.pin.pals.server.dto;

import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
@Data
public class CurrentPinsDTO {
    private Long numberOfPeople;
    private Long hostUserId;

    private String pin;
    private Float latitude;
    private Float longitude;

    private Long expireAtMinutes;

    private List<Long> groupsId;


    public CurrentPinsDTO() {};

}
