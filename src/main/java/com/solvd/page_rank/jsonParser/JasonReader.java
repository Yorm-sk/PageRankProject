package com.solvd.page_rank.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JasonReader {

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

    public static void writeToJSON() {

        Site site = new Site();
        site.setUrl("fefefef.efefef");
        List<String> links = new ArrayList<>();
        links.add("sadsdas");
        links.add("sadsdas");
        links.add("sadsdas");

        site.setRefs(links);
        ObjectMapper om = new ObjectMapper();

        File file = new File("src/main/resources/sites/site.json");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        try {
            om.writeValue(file, site);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

}
