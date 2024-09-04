package com.dev.spring_boot.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)//field nao null thi khong hien thi
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    int code = 1000;
    String message;
    T result;
}
