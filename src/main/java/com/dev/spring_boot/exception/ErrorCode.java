package com.dev.spring_boot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    INVALID_KEY(1001, "Invalid message key!"),
    USER_EXISTED(1002, "User existed!"),
    INVALID_USERNAME(1003, "Username must be at least 3 character"),
    INVALID_PASSWORD(1003, "Password must be at least 8 character"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error!");

    private int code;
    private String message;
}
