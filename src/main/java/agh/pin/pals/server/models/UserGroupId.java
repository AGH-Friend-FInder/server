package agh.pin.pals.server.models;

import java.io.Serializable;
import java.util.Objects;

public class UserGroupId implements Serializable {

    private Long user;
    private Long group;

    public UserGroupId() {
    }

    public UserGroupId(Long user, Long group) {
        this.user = user;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroupId)) return false;
        UserGroupId that = (UserGroupId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, group);
    }
}
