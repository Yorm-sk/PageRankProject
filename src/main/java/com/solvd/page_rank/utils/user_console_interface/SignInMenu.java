package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.UsersDAO;
import com.solvd.page_rank.exceptions.WrongLoginException;
import com.solvd.page_rank.exceptions.WrongPasswordException;
import com.solvd.page_rank.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SignInMenu {
    private static final Logger LOGGER = LogManager.getLogger(SignInMenu.class);

    public static Users signIn(Scanner scan) {
        UsersDAO dao = new UsersDAO();
        Users user = new Users();
        while (true) {
            try {
                LOGGER.info("Enter your name please:");
                String login = scan.next();
                List<Users> users = dao.getAllEntity();
                List<String> usersLogin;
                usersLogin = users.stream().map(Users::getLogin).collect(Collectors.toList());
                if (!usersLogin.contains(login)) throw new WrongLoginException();
                user.setLogin(login);
                break;
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());

            }
        }
        while (true) {
            try {
                user = dao.getUserByLogin(user.getLogin());
                LOGGER.info("Enter a password, please:");
                String password = scan.next();
                if (!password.equals(user.getPassword())) throw new WrongPasswordException();
                break;
            } catch (WrongPasswordException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        LOGGER.info("User sign in");
        return user;
    }
}
