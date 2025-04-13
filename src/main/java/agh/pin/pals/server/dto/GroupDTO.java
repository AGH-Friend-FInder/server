package agh.pin.pals.server.dto;

import lombok.Data;

@Data
public class GroupDTO {
    private String groupName;
    private Boolean isPublic;
    private String color;
}
