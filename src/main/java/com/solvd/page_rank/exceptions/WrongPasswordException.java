package com.solvd.page_rank.exceptions;

public class WrongPasswordException extends  Exception{
    public WrongPasswordException() {
        this("You enter wrong password");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
