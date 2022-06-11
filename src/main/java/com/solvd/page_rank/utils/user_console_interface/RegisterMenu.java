package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.exceptions.WrongLoginException;
import com.solvd.page_rank.exceptions.WrongPasswordException;
import com.solvd.page_rank.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterMenu {
    private static final Logger LOGGER = LogManager.getLogger(RegisterMenu.class);

    public static Users register(Scanner scanner) {
        Users user = new Users();
        while (true) {
            try {
                LOGGER.info("\nGreat, enter your login:\n" +
                        "It has to be from 4 to 11 symbols, and contain only latin symbols, digits or underscore(_)");
                String login = scanner.next();
                if (!checkLogin(login)) throw new WrongLoginException("You login is not valid");
                user.setLogin(login);
                break;
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        while (true) {
            try {
                LOGGER.info("\nEnter your password now:\n" +
                        "It has to be from 5 to 16 symbols, and contain only latin symbols, digits or underscore(_)\n" +
                        "It must contain at least one digit, one small latin, one uppercase letter");
                String password = scanner.next();
                if (!checkPassword(password)) throw new WrongPasswordException("Your password does`nt valid");
                LOGGER.info("Enter password one more time");
                String passwordForValidations = scanner.next();
                if (!password.equals(passwordForValidations)) throw new WrongPasswordException("Your password does`nt same");
                user.setPassword(password);
                break;
            } catch (WrongPasswordException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        //TODO:Add user to database and get it back
        LOGGER.info("User registered");
        return user;
    }

    private static boolean checkLogin(String login) {
        return Pattern.matches("^(\\w){4,11}$", login);
    }

    private static boolean checkPassword(String password) {
        return Pattern.matches("^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\s+$))\\w{5,16}$", password);
    }
}
