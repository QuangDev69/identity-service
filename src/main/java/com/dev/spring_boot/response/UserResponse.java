package com.dev.spring_boot.response;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String firstName;

    String lastName;

    @Size(min = 3, message = "INVALID_USERNAME")
    String username;

    String email;

    String phoneNumber;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    LocalDate birthday;
}
