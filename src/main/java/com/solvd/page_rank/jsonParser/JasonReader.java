package com.solvd.page_rank.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
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
            Site site = om.readValue(new File("src/main/resources/sites/"+siteUrl+".json"), Site.class);
                return site;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }



}
