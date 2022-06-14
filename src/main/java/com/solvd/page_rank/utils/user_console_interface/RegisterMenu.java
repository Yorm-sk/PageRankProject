package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.mybatis.SettingsForAlgorythmDAO;
import com.solvd.page_rank.dao.mybatis.UsersDAO;
import com.solvd.page_rank.exceptions.WrongLoginException;
import com.solvd.page_rank.exceptions.WrongPasswordException;
import com.solvd.page_rank.models.SettingsForAlgorythm;
import com.solvd.page_rank.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegisterMenu {
    private static final Logger LOGGER = LogManager.getLogger(RegisterMenu.class);

    public static Users register(Scanner scanner) {
        UsersDAO dao = new UsersDAO();
        Users user = new Users();
        boolean exit = false;
        while (true) {
            try {
                LOGGER.info("\nGreat, enter your login(enter 'stop' to exit):\n" +
                        "It has to be from 4 to 11 symbols, and contain only latin symbols, digits or underscore(_)");
                String login = scanner.next();
                if (login.equals("stop")) {
                    user = null;
                    exit = true;
                    break;
                }
                if (!checkLogin(login)) throw new WrongLoginException("You login is not valid");
                List<Users> users = dao.getAllEntity();
                List<String> usersLogin;
                usersLogin = users.stream().map(Users::getLogin).collect(Collectors.toList());
                if (usersLogin.contains(login)) throw new WrongLoginException("This user is already exists");
                user.setLogin(login);
                break;
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        while (true) {
            try {
                if (exit) break;
                LOGGER.info("\nEnter your password now:\n" +
                        "It has to be from 5 to 16 symbols, and contain only latin symbols, digits or underscore(_)\n" +
                        "It must contain at least one digit, one small latin, one uppercase letter");
                String password = scanner.next();
                if (!checkPassword(password)) throw new WrongPasswordException("Your password does`nt valid");
                LOGGER.info("Enter password one more time");
                String passwordForValidations = scanner.next();
                if (!password.equals(passwordForValidations))
                    throw new WrongPasswordException("Your password does`nt same");
                user.setPassword(password);
                break;
            } catch (WrongPasswordException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        if (!exit) {
            dao.createEntity(user);
            user = dao.getUserByLogin(user.getLogin());
            new SettingsForAlgorythmDAO().createEntity(new SettingsForAlgorythm(0.85, 0.09, user));
            LOGGER.info("User registered");
        }
        return user;
    }

    private static boolean checkLogin(String login) {
        return Pattern.matches("^(\\w){4,11}$", login);
    }

    private static boolean checkPassword(String password) {
        return Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,16}$", password);
    }
}
