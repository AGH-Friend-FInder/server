package agh.pin.pals.server.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {
    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Login cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
