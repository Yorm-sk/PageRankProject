package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.exceptions.WrongLoginException;
import com.solvd.page_rank.exceptions.WrongPasswordException;
import com.solvd.page_rank.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SignInMenu {
    private static final Logger LOGGER = LogManager.getLogger(SignInMenu.class);

    public static Users signIn(Scanner scan) {
        Users user = new Users();
        while (true) {
            try {
                LOGGER.info("Enter your name please:");
                String login = scan.next();
                //TODO: check if name is in table
                if (!login.equals("some check")) throw new WrongLoginException();
                user.setLogin(login);
                break;
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        while (true) {
            try {
                //TODO: get user by login
                LOGGER.info("Enter a password, please:");
                String password = scan.next();
                //TODO:compare entered pass with user pass
                if (password.equals("123")) throw new WrongPasswordException();
                break;
            } catch (WrongPasswordException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        LOGGER.info("User sign in");
        return user;
    }
}
