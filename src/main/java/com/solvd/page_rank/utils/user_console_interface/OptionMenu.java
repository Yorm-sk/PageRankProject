package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.PagesToRankDAO;
import com.solvd.page_rank.dao.SettingsForAlgorythmDAO;
import com.solvd.page_rank.dao.UsersDAO;
import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.Pages;
import com.solvd.page_rank.models.PagesToRank;
import com.solvd.page_rank.models.SettingsForAlgorythm;
import com.solvd.page_rank.models.Users;
import com.solvd.page_rank.utils.convertToMatrix.Converter;
import com.solvd.page_rank.utils.jsonParser.JasonReader;
import com.solvd.page_rank.utils.page_rank_algorythm.MyAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

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
                        rankPages(user);
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

    private void rankPages(Users user) {
        //Read pages to rank from dao
        UsersDAO dao = new UsersDAO();
        boolean exit = true;
        SettingsForAlgorythmDAO settingsDao = new SettingsForAlgorythmDAO();
        user.setPagesToRanks(dao.getPagesToRank(user.getId()));
        if (user.getPagesToRanks().isEmpty()) {
            LOGGER.info("You must choose pages first");
            exit = false;
        }

        if (exit) {
            List<Pages> pagesToParse = new ArrayList<>();
            for (PagesToRank pageToRank : user.getPagesToRanks()) {
                pagesToParse.add(pageToRank.getPage());
            }

            //parse list to array
            List<String> usersPagesUrls;
            usersPagesUrls = pagesToParse.stream().map(Pages::getUrl).collect(Collectors.toList());
            Converter converter = new Converter(usersPagesUrls);
            converter.startCompareSites();    // needs to have .json files

            //calculating page rank
            MyAlgorithm algorithm = new MyAlgorithm();
            algorithm.setRelations(converter.getGraph().getMtrx());
            SettingsForAlgorythm settings = settingsDao.getSettingsByUserID(user.getId());
            algorithm.setDampingFactor(settings.getDempingFactor());
            algorithm.setLimitOfDefect(settings.getLimitOfDeflect());
            algorithm.calculatePageRank(pagesToParse.size());

            //update dao (insert page rank)
            for (PagesToRank page : user.getPagesToRanks()) {
                page.setRank(algorithm.getPageRank()[user.getPagesToRanks().indexOf(page)]);
            }
            PagesToRankDAO rankDAO = new PagesToRankDAO();
            for (PagesToRank page : user.getPagesToRanks()) {
                rankDAO.updateEntity(page);
            }

            //writing file with page ranks
            StringBuilder resultForUser = new StringBuilder();
            resultForUser.append("Page rank for user with login ").append(user.getLogin()).append(":\n");
            for (PagesToRank page : user.getPagesToRanks()) {
                String url = page.getPage().getUrl();
                resultForUser.append(url).append("- has page rank = ").append(page.getRank()).append("\n");
            }
            LOGGER.info(resultForUser);
            new JasonReader().writeToJSON(resultForUser.toString(), user);
            LOGGER.info("json wrote");
        }
    }
}
