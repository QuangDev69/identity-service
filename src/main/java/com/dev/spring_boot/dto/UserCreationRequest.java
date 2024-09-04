package com.dev.spring_boot.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreationRequest {

    private String firstName;

    private String lastName;

    @Size(min=3, message = "INVALID_USERNAME")
    private String username;

    private String email;

    private String phoneNumber;

    @Size(min=8, message = "INVALID_PASSWORD")
    private String password;

    private LocalDate birthday;
}
