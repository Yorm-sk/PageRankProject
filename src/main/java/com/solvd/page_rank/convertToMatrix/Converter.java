package com.solvd.page_rank.convertToMatrix;

import com.solvd.page_rank.graphs.AMWGraph;
import com.solvd.page_rank.jsonParser.JasonReader;
import com.solvd.page_rank.jsonParser.Site;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {

    private List<String> siteNames = new ArrayList<>();
    private  List<Site> sites = new ArrayList<>();
    private static AMWGraph graph;

    public Converter() {}

    public Converter(String args[]) {
       siteNames = new ArrayList<>();
        Collections.addAll(siteNames, args);
    }

    public void setSites() {
        siteNames.add("site1");
        siteNames.add("site2");
        siteNames.add("site3");
        siteNames.add("site4");
        siteNames.add("site5");
    }

    public void createGraphs() {
        AMWGraph graph = new AMWGraph(siteNames.size());
    }


    public void startCompareSites() {
        sites = new ArrayList<>();
        sites = JasonReader.getListOfSites(siteNames);

        createGraphs();

        int coll = 0;
        for (Site eachSite : sites) {
          int row = 0;
          coll++;
           for( String eachUrl : eachSite.getLinks() ) {
             row++;
               for ( Site eachCompareSite : sites) {

                   if(eachSite.getUrl()!=eachCompareSite.getUrl())
                   if (eachUrl == eachCompareSite.getUrl()) {

                       graph.insertConToMatrix(coll,row);
                   }

               }

           }





        }

    }





}
