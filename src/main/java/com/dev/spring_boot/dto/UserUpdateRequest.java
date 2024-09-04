package com.dev.spring_boot.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String password;
    LocalDate birthday;
}
