package com.solvd.page_rank;

import com.solvd.page_rank.convertToMatrix.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Test");
        //TestAMWGraph.run();

        Converter con = new Converter();
        con.setSites();
        con.createGraphs();
        con.startCompareSites();

    }
}
