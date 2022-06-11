package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.exceptions.WrongNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private static final Logger LOGGER = LogManager.getLogger(MainMenu.class);

    public MainMenu(){
        try (Scanner scanner = new Scanner(System.in)){
            showMenu(scanner);
        }
    }

    private void showMenu(Scanner scan){
        LOGGER.info("\nHello user, select an option, please\n" +
                "1 - sign in\n" +
                "2 - register");
        while (true){
            try {
                LOGGER.info("\n1 - sign in\n" +
                        "2 - register");
                int choice = scan.nextInt();
                if (choice !=1 && choice != 2) throw new WrongNumberException();
                switch (choice){
                    case 1:
                        //TODO: show menu to sign in
                        break;
                    case 2:
                        //TODO: show registration menu
                        break;
                }
                break;
            } catch (InputMismatchException e){
                LOGGER.warn("You enter not an integer...");
                scan.next();
            } catch (WrongNumberException e){
                LOGGER.warn("There is no such option");
            }
        }
    }
}
