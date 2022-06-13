package com.solvd.page_rank.utils.convertToMatrix;

import com.solvd.page_rank.utils.graphs.AMWGraph;
import com.solvd.page_rank.utils.jsonParser.JasonReader;
import com.solvd.page_rank.utils.jsonParser.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {
    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

    private List<String> siteNames = new ArrayList<>();
    private List<Site> sites = new ArrayList<>();
    private AMWGraph graph;
    public Converter() {
    }

    public Converter(String[] args) {
        siteNames = new ArrayList<>();
        Collections.addAll(siteNames, args);
    }

    public Converter(List<String> pagesList) {
        siteNames = pagesList;
    }

    public void setSites() {
        siteNames.add("site1");
        siteNames.add("site2");
        siteNames.add("site3");
        siteNames.add("site4");
        siteNames.add("site5");
    }

    public AMWGraph createGraphs() {
        AMWGraph graph = new AMWGraph(siteNames.size());
        for (String sitename : siteNames) {
            graph.insertVertex(sitename); // add node
        }
        return graph;
    }

    public AMWGraph getGraph() {
        return graph;
    }

    public void startCompareSites() {
        sites = new ArrayList<>();
        sites = JasonReader.getListOfSites(siteNames);

        graph = createGraphs();

        int coll = 0;
        for (Site eachSite : sites) {

            int row = 0;
            coll++;
            for (String eachUrl : eachSite.getLinks()) {

                row++;

                int num = 0;
                for (Site eachCompareSite : sites) {
                    num++;
                    if (eachSite.getUrl().contentEquals(eachCompareSite.getUrl())) {
                    } else if (eachUrl.contentEquals(eachCompareSite.getUrl())) {
                        graph.insertConToMatrix(coll, num);
                    }
                }
            }
        }
    }

    public void logGraph() {
        for (int c = 0; c <= getGraph().getNumOfVertex() - 1; c++) {
            System.out.println();
            LOGGER.info("\"\\n\"");
            for (int r = 0; r <= getGraph().getNumOfVertex() - 1; r++) {
                LOGGER.info(" " + getGraph().getElementOfMtrx(c, r));
            }
        }
    }


}
