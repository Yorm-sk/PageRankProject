package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionMenu {
    private static final Logger LOGGER = LogManager.getLogger(OptionMenu.class);

    public OptionMenu(Scanner scanner, Users user) {
        showMenu(scanner, user);
    }

    private void showMenu(Scanner scanner, Users user) {
        while (true) {
            try {
                LOGGER.info("\nWelcome to option menu, " + user.getLogin() + ", choose option\n" +
                        "1 - Work with urls\n" +
                        "2 - Choose sites to rank\n" +
                        "3 - Rank sites\n" +
                        "4 - Set up setting (change damping level(default - 0.85), limit of deflect (default - 0.09))\n" +
                        "5 - Log out");
                int choice = scanner.nextInt();
                if (choice < 1 || choice > 5) throw new WrongNumberException();
                switch (choice) {
                    case 1:
                        new WorkWithUrlsMenu(scanner);
                        break;
                    case 2:
                        new PagesToChooseMenu(scanner, user);
                        break;
                    case 3:
                        //TODO:start algorithm
                        break;
                    case 4:
                        new WorkWithSettingMenu(scanner, user.getId());
                    case 5:
                        LOGGER.info("Logging out...");
                        break;
                }
                if (choice == 5) break;
            } catch (InputMismatchException e) {
                LOGGER.warn("You entered not a number");
            } catch (WrongNumberException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }
}
