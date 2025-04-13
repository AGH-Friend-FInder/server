package agh.pin.pals.server.models;

import java.io.Serializable;
import java.util.Objects;

public class CurrentPinsGroupsId implements Serializable {

    private Long currentPin;
    private Long group;

    public CurrentPinsGroupsId() {}

    public CurrentPinsGroupsId(Long currentPin, Long group) {
        this.currentPin = currentPin;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentPinsGroupsId)) return false;
        CurrentPinsGroupsId that = (CurrentPinsGroupsId) o;
        return Objects.equals(currentPin, that.currentPin) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPin, group);
    }
}

