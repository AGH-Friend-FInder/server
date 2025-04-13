package agh.pin.pals.server.dto;

import agh.pin.pals.server.models.CurrentPins;
import agh.pin.pals.server.models.Group;
import agh.pin.pals.server.models.User;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public CurrentPinsDTO(CurrentPins currentPins) {
        this.numberOfPeople = currentPins.getNumberOfPeople();
        this.hostUserId = currentPins.getHostUser().getId();
        this.pin = currentPins.getPin();
        this.latitude = currentPins.getLatitude();
        this.longitude = currentPins.getLongitude();
        Timestamp expireAt = currentPins.getExpireAt();
        if (expireAt != null) {
            ZoneId zone = ZoneId.of("Europe/Warsaw");
            ZonedDateTime nowInPoland = ZonedDateTime.now(zone);
            ZonedDateTime expireAtInPoland = expireAt.toInstant().atZone(zone);
            this.expireAtMinutes = Duration.between(nowInPoland, expireAtInPoland).toMinutes();
        } else {
            this.expireAtMinutes = null;
        }


        this.groupsId = currentPins.getGroups()
                .stream()
                .map(Group::getId)
                .collect(Collectors.toList());

    }

}
