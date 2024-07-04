package com.namnam.musicapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.apache.bcel.classfile.Unknown;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN_EXCEPTION(999, "Unknown error"),
    INVALID_VALIDATE_KEY(9999, "Invalid validate ErrorCode"),

    //Blank
    PHONE_BLANK(1002, "Phone is required"),
    PASSWORD_BLANK(1003, "Password is required"),
    SINGER_NAME_BLANK(1004, "Singer's name is required"),
    SONG_NAME_BLANK(1004, "Song's name is required"),
    COMPOSER_NAME_BLANK(1004, "Composer's name is required"),

    //Existed
    USER_EXISTED(2001, "User existed"),
    SINGER_EXISTED(2001, "Singer's name existed"),
    COMPOSER_EXISTED(2001, "Composer's name existed"),

    //Invalid
    PHONE_INVALID(3001, "Phone must be at least 10 characters"),
    PASSWORD_INVALID(3002, "Password must be at least 8 characters"),

    ;

    private final int code;
    private final String message;
}
