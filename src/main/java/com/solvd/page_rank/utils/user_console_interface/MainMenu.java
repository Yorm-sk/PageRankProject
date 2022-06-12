package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.exceptions.WrongNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenu {
    private static final Logger LOGGER = LogManager.getLogger(MainMenu.class);

    public MainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            showMenu(scanner);
        }
    }

    private void showMenu(Scanner scan) {
        while (true) {
            try {
                LOGGER.info("\nHello user, select an option, please\n" +
                        "1 - sign in\n" +
                        "2 - register\n" +
                        "3 - exit");
                int choice = scan.nextInt();
                if (choice < 1 || choice > 3) throw new WrongNumberException();
                switch (choice) {
                    case 1:
                        new OptionMenu(scan, SignInMenu.signIn(scan));
                        break;
                    case 2:
                        new OptionMenu(scan, RegisterMenu.register(scan));
                        break;
                    case 3:
                        LOGGER.info("Thanks for using our program!");
                        break;
                }
                if (choice == 3) break;
            } catch (InputMismatchException e) {
                LOGGER.warn("You enter not an integer...");
                scan.next();
            } catch (WrongNumberException e) {
                LOGGER.warn("There is no such option");
            }
        }
    }
}
