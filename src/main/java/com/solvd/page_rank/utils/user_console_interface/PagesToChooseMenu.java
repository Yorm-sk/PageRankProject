package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.PagesDAO;
import com.solvd.page_rank.exceptions.NotEnoughPagesToRankException;
import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.Pages;
import com.solvd.page_rank.models.Users;
import com.solvd.page_rank.utils.convertToMatrix.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        //TODO:parse chosenOne to PagesToRank and insert them into tables
        List<String> usersPagesUrls;
        usersPagesUrls = chosenOne.stream().map(Pages::getUrl).collect(Collectors.toList());
        Converter converter = new Converter(usersPagesUrls);
        converter.startCompareSites();    // needs to have .json files
        converter.getGraph().getMtrx();   // return int[][] - connection table of Pages and links
/*            
        MyAlgorithm obj = new MyAlgorithm();
        obj.setRelations (converter.getGraph().getMtrx());
        obj.calculatePageRank();
        List<PagesToRank> chosenPagesToRank = obj.getListPagesToRank();

        PagesToRankDAO pagesToRankDAO = new PagesToRankDAO();

        for (PagesToRank onePageToRank : chosenPagesToRank) {
            pagesToRankDAO.createEntity(onePageToRank);
        }
*/

    }
}
