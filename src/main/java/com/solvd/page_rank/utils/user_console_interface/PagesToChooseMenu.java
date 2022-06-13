package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.PagesDAO;
import com.solvd.page_rank.exceptions.NotEnoughPagesToRankException;
import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.Pages;
import com.solvd.page_rank.models.Users;
import com.solvd.page_rank.utils.convertToMatrix.Converter;
import com.solvd.page_rank.utils.graphs.AMWGraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PagesToChooseMenu {
    private static final Logger LOGGER = LogManager.getLogger(PagesToChooseMenu.class);

    public PagesToChooseMenu(Scanner scanner, Users user) {
        showMenu(scanner, user);
    }

    private void showMenu(Scanner scanner, Users user) {
        PagesDAO dao = new PagesDAO();
        List<Pages> pages = dao.getAllEntity();
        List<Pages> chosenOne = new ArrayList<>();
        while (true) {
            try {
                LOGGER.info("Here sites you can choose for rank(enter -1 to stop choosing):");
                pages.forEach(page -> LOGGER.info(pages.indexOf(page) + ":" + page.getUrl()));
                int choice = scanner.nextInt();
                if (choice < -1 || choice > pages.size() - 1) throw new WrongNumberException();
                if (choice == -1 && chosenOne.size() < 3) throw new NotEnoughPagesToRankException();
                if (choice == -1) {
                    LOGGER.info("Your list is ready");
                    break;
                } else chosenOne.add(pages.get(choice));
            } catch (InputMismatchException e) {
                LOGGER.warn("You enter not an integer");
                scanner.next();
            } catch (WrongNumberException | NotEnoughPagesToRankException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        new Converter().getGraph().getMtrx();
        //TODO:parse chosenOne to PagesToRank and insert them into tables
    }
}
