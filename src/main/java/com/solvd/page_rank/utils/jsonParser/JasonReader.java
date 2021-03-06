package com.solvd.page_rank.utils.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.page_rank.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JasonReader {
    private static final Logger LOGGER = LogManager.getLogger(JasonReader.class);

    static List<Site> sites;

    public static List<Site> getListOfSites(List<String> siteNames) {
        sites = new ArrayList<>();

        for(String eachSite : siteNames) sites.add(readFromJSON(eachSite));
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

    public void writeToJSON(Site site, String siteName) {

        ObjectMapper om = new ObjectMapper();

        File file = new File("src/main/resources/sites/"+ siteName + ".json");
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

    public static void writeToJSON(String stringToWrite, Users user){
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String[] lines = stringToWrite.split("\\r?\\n");
            JSONObject jsonObject = new JSONObject();
            JSONObject tempjsonObject = new JSONObject();
            jsonObject.put("title", lines[0]);
            for (int i = 1; i < lines.length; i++) {
                tempjsonObject.put("rank" + i, lines[i]);
            }
            jsonObject.put("ranks", tempjsonObject);
            objectMapper.writeValue(new File("src/main/resources/resultOfAlgorithm/" + user.getLogin() + ".json"),
                    jsonObject);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

}
