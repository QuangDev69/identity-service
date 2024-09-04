package com.dev.spring_boot.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate birthday;
}
