package com.solvd.page_rank.utils.user_console_interface;

import com.solvd.page_rank.dao.PagesDAO;
import com.solvd.page_rank.exceptions.WrongLoginException;
import com.solvd.page_rank.exceptions.WrongNumberException;
import com.solvd.page_rank.models.Pages;
import com.solvd.page_rank.utils.jsonParser.JasonReader;
import com.solvd.page_rank.utils.jsonParser.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                        addSite(scanner);
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

    private void addSite(Scanner scanner) {
        PagesDAO dao = new PagesDAO();
        Site site = new Site();
        String name;
        while (true) {
            try {
                LOGGER.info("Enter site name");
                name = scanner.next();
                List<Pages> pages = dao.getAllEntity();
                List<String> urls;
                urls = pages.stream().map(Pages::getUrl).collect(Collectors.toList());
                if (urls.contains(name)) throw new WrongLoginException("Such name already exists");
                break;
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        while (true) {
            try {
                LOGGER.info("Enter url of site:");
                String url = scanner.next();
                if (!url.startsWith("https:\\")) throw new WrongLoginException("Url must start from https:\\");
                site.setUrl(url);
                break;
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        List<String> links = new ArrayList<>();
        while (true) {
            try {
                LOGGER.info("Enter links for site(enter stop, if there is no urls):");
                String link = scanner.next();
                if (link.equals("stop") && links.size() == 0)
                    throw new WrongLoginException("You must have at least one link");
                if (link.equals("stop")) {
                    break;
                } else {
                    if (!link.startsWith("https:\\")) throw new WrongLoginException("Url must start from https:\\");
                    links.add(link);
                }
            } catch (WrongLoginException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        site.setRefs(links);
        new JasonReader().writeToJSON(site, name);
        dao.createEntity(new Pages(name));
        LOGGER.info("Site added");
    }

    private void removeSite(Scanner scanner) {
        PagesDAO dao = new PagesDAO();
        List<Pages> pages;
        while (true) {
            try {
                LOGGER.info("Chose site you want to remove (if uou don`t want to enter -1):");
                pages = dao.getAllEntity();
                pages.forEach(page -> LOGGER.info(page.getId() + ": " + page.getUrl()));
                List<Integer> ids;
                ids = dao.getAllEntity().stream().map(Pages::getId).collect(Collectors.toList());
                int choice = scanner.nextInt();
                if (choice == -1) break;
                else {
                    if (!ids.contains(choice)) throw new WrongNumberException();
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
