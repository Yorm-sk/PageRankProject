package com.solvd.page_rank.utils;

public class WrongNumberException extends Exception{
    public WrongNumberException() {
        this("You enter not valid number");
    }

    public WrongNumberException(String message) {
        super(message);
    }
}
