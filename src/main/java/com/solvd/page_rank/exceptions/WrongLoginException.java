package com.solvd.page_rank.exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        this("No user with such login registered");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
