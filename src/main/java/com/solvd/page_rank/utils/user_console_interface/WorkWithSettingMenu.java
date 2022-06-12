package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.SettingsForAlgorythmDAO;
import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.SettingsForAlgorythm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkWithSettingMenu {
    private static final Logger LOGGER = LogManager.getLogger(WorkWithSettingMenu.class);

    public WorkWithSettingMenu(Scanner scanner, int userId) {
        showMenu(scanner, userId);
    }

    private void showMenu(Scanner scanner, int userId) {
        while (true) {
            try {
                LOGGER.info("\nHere you can change algorithm settings\n" +
                        "1 - damping level\n" +
                        "2 - limit of deflect\n" +
                        "3 - previous menu");
                int choice = scanner.nextInt();
                if (choice < 1 || choice > 3) throw new WrongNumberException();
                switch (choice) {
                    case 1:
                        changeDampingLevel(scanner, userId);
                        break;
                    case 2:
                        changeLimitOfDeflect(scanner, userId);
                        break;
                    case 3:
                        LOGGER.info("Going to previous menu");
                        break;
                }
                if (choice == 3) break;
            } catch (InputMismatchException e) {
                LOGGER.warn("You entered not a number");
            } catch (WrongNumberException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private void changeDampingLevel(Scanner scanner, int userId) {
        SettingsForAlgorythmDAO dao = new SettingsForAlgorythmDAO();
        SettingsForAlgorythm settings = dao.getSettingsByUserID(userId);
        while (true) {
            try {
                LOGGER.info("Now damping level = " + settings.getDempingFactor());
                LOGGER.info("Enter new level (it have to between 0 and 1):");
                double damp = scanner.nextDouble();
                if (damp <= 0 || damp >= 1) throw new WrongNumberException("It have to between 0 and 1");
                settings.setDempingFactor(damp);
                dao.updateEntity(settings);
                LOGGER.info("Damping level is changed");
                break;
            } catch (InputMismatchException e) {
                LOGGER.warn("You enter not a double");
                scanner.next();
            } catch (WrongNumberException e){
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private void changeLimitOfDeflect(Scanner scanner, int userId) {
        SettingsForAlgorythmDAO dao = new SettingsForAlgorythmDAO();
        SettingsForAlgorythm settings = dao.getSettingsByUserID(userId);
        while (true) {
            try {
                LOGGER.info("Now deflection limit = " + settings.getLimitOfDeflect());
                LOGGER.info("Enter new limit (it have to between 0.05 and 0.15):");
                double defl = scanner.nextDouble();
                if (defl <= 0.05 || defl >= 0.15) throw new WrongNumberException("It have to between 0.05 and 0.15");
                settings.setLimitOfDeflect(defl);
                dao.updateEntity(settings);
                LOGGER.info("limit of deflect is changed");
                break;
            } catch (InputMismatchException e) {
                LOGGER.warn("You enter not a double");
                scanner.next();
            } catch (WrongNumberException e){
                LOGGER.warn(e.getMessage());
            }
        }
    }
}
