package com.solvd.page_rank.utils.userConsoleInterface;

import com.solvd.page_rank.dao.mybatis.UsersDAO;
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
        boolean exit = false;
        while (true) {
            try {
                LOGGER.info("Enter your name please(enter 'stop' if want exit to previous menu):");
                String login = scan.next();
                if (login.equals("stop")) {
                    user = null;
                    exit = true;
                    break;
                }
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
                if (exit) break;
                user = dao.getUserByLogin(user.getLogin());
                LOGGER.info("Enter a password, please:");
                String password = scan.next();
                if (!password.equals(user.getPassword())) throw new WrongPasswordException();
                LOGGER.info("User sign in");
                break;
            } catch (WrongPasswordException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        return user;
    }
}
