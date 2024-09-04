package com.dev.spring_boot.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //field nao null thi khong hien thi
public class ApiResponse<T> {
    private int code = 1000;
    private String message;
    private T result;
}
