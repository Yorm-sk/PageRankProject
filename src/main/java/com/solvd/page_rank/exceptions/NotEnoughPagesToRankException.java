package com.solvd.page_rank.exceptions;

public class NotEnoughPagesToRankException extends Exception{
    public NotEnoughPagesToRankException() {
        this("You must choose two or more size for Rank");
    }

    public NotEnoughPagesToRankException(String message) {
        super(message);
    }
}
