package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.PagesDAO;
import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.Pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WorkWithUrlsMenu {
    private static final Logger LOGGER = LogManager.getLogger(WorkWithUrlsMenu.class);

    public WorkWithUrlsMenu(Scanner scanner) {
        showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            try {
                LOGGER.info("\nChoose what do you want to do:\n" +
                        "1 - add site\n" +
                        "2 - remove site\n" +
                        "3 - previous menu");
                int choice = scanner.nextInt();
                if (choice < 1 || choice > 3) throw new WrongNumberException();
                switch (choice) {
                    case 1:
                        //TODO:make function to add sites
                        break;
                    case 2:
                        removeSite(scanner);
                        break;
                    case 3:
                        LOGGER.info("Going to previous menu");
                        break;
                }
                if (choice == 3) break;
            } catch (InputMismatchException e) {
                LOGGER.warn("You enter not an integer");
            } catch (WrongNumberException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private void removeSite(Scanner scanner) {
        PagesDAO dao = new PagesDAO();
        List<Pages> pages = dao.getAllEntity();
        while (true) {
            try {
                LOGGER.info("Chose site you want to remove (if uou don`t want to enter -1):");
                pages.forEach(page -> LOGGER.info(page.getId() + ": " + page.getUrl()));
                int choice = scanner.nextInt();
                if (choice < -1 || choice > pages.size() - 1) throw new WrongNumberException();
                if (choice == -1) break;
                else {
                    LOGGER.info("Deleted site with id - " + choice);
                    dao.deleteEntity(choice);
                }
            } catch (InputMismatchException e) {
                LOGGER.warn("You enter not an integer");
            } catch (WrongNumberException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }
}
