package com.solvd.page_rank.utils.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.page_rank.dao.PagesDAO;
import com.solvd.page_rank.models.Pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JasonReader {
    private static final Logger LOGGER = LogManager.getLogger(JasonReader.class);

    static List<Site> sites;

    public static List<Site> getListOfSites(List<String> siteNames) {
        sites = new ArrayList<>();

        for(String eachSite : siteNames)
        sites.add(readFromJSON(eachSite));

        return sites;
    }

    public static Site readFromJSON(String siteUrl) {

        ObjectMapper om = new ObjectMapper();
        try {
            Site site = new Site();
                   site = om.readValue(new File("src/main/resources/sites/"+siteUrl+".json"), Site.class);
                return site;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public static void writeToJSON(Site site, String siteName) {

        ObjectMapper om = new ObjectMapper();
        PagesDAO dao = new PagesDAO();
        List<Pages> pages = dao.getAllEntity();
        File file = new File("src/main/resources/sites/site.json");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
               LOGGER.error("File does`nt exist!");
            }

        try {
            om.writeValue(file, site);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

    }

}
