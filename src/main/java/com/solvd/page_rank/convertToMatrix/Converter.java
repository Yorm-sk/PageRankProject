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
    private AMWGraph graph;

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
        for(String sitename :siteNames) {
            graph.insertVertex (sitename); // Вставляем узел
        }
    }

    public AMWGraph getGraph() {
        return graph;
    }
    public void startCompareSites() {
        sites = new ArrayList<>();
        sites = JasonReader.getListOfSites(siteNames);

        AMWGraph graph = new AMWGraph(siteNames.size());
        for(String sitename :siteNames) {
            graph.insertVertex (sitename); // Вставляем узел
        }

        int coll = 0;
        for (Site eachSite : sites) {
           // System.out.println(eachSite.getUrl());
            int row = 0;
          coll++;
           for( String eachUrl : eachSite.getLinks() ) {
              // System.out.println(eachUrl);
             row++;

             int num = 0;
               for ( Site eachCompareSite : sites) {
num++;
                   if(eachSite.getUrl().contentEquals(eachCompareSite.getUrl())) {
                   }
                   else if (eachUrl.contentEquals(eachCompareSite.getUrl())) {
                       System.out.println(eachUrl);
                       System.out.println(eachCompareSite.getUrl()+" "+ coll+" "+row+" "+num);
                      graph.insertConToMatrix(coll,num);
                   }
               }
           }



        }

        for (int c = 0; c<= graph.getNumOfVertex()-1; c++) {
            System.out.println();
            for (int r = 0; r <= graph.getNumOfVertex()-1; r++) {
                System.out.print(" " + graph.getElementOfMtrx(c, r));
            }
        }

    }
}
