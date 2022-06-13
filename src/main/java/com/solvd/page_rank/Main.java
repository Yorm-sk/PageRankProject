package com.solvd.page_rank;

import com.solvd.page_rank.dao.PagesDAO;
import com.solvd.page_rank.models.Pages;
import com.solvd.page_rank.utils.user_console_interface.MainMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
       new MainMenu();
    }
}