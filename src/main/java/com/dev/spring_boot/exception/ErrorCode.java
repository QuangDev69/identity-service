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
    USER_NOT_EXISTED(1004, "User not existed!"),
    INVALID_USERNAME(1005, "Username must be at least 3 character"),
    INVALID_PASSWORD(1005, "Password must be at least 8 character"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error!"),
    UNAUTHENTICATED(1006, "Unauthenticated");

    private int code;
    private String message;
}
