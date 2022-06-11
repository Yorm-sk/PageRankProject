package com.solvd.page_rank.utils.page_rank_algorythm;

import com.solvd.page_rank.exceptions.WrongNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class MyAlgorithm {
    private static final Logger LOGGER = LogManager.getLogger(MyAlgorithm.class);

    private int[][] relations; //contain information about links between sites
    private double[] pageRank;
    double[] previousPageRank;

    public void calculatePageRank(int sitesQuantity, Scanner scanner) {
        relations = new int[sitesQuantity][sitesQuantity];
        pageRank = new double[sitesQuantity];
        setRelations(sitesQuantity, scanner);
        previousPageRank = new double[sitesQuantity];
        Arrays.fill(pageRank, (double) 1 / sitesQuantity); //on first iteration all sites has same rank

        double dampingFactor = 0.85;

        double limitOfDefect = 0.09; // needed to reduce deflection on each iteration
        previousPageRank = Arrays.copyOf(pageRank, pageRank.length);
        iteratePageRank(dampingFactor, sitesQuantity);
        for (int i = 0; i < pageRank.length; i++) {
            if (Math.abs(pageRank[i] - previousPageRank[i]) > limitOfDefect) {
                previousPageRank = Arrays.copyOf(pageRank, pageRank.length);
                iteratePageRank(dampingFactor, sitesQuantity);
            }
        }
    }

    public double sumOfRanks() {
        double sum = 0;
        for (double rank : pageRank) {
            sum += rank;
        }
        return sum;
    }

    /**
     * Calculate rank for each page by formula PR(pi) = (1-d) + d * (PR(pj)/C(pj) + ... + PR(pn)/C(pn)
     * PR(pi) - page rank of page i
     * d - damping coefficient, shows if user click on page on purpose or randomly
     * PR(pj) - page rank of page j (page that have outdoor link to page i)
     * C(pj) - outdoor links of page j
     * PR(pn) - page rank of page n (page that have outdoor link to page i)
     * C(pn) - outdoor links of page n
     * Also if site has no outdoor links distribute it rank between other pages
     **/
    private void iteratePageRank(double dampingLevel, int sitesQuantity) {
        List<Integer> pits = new ArrayList<>(); //needed if we have "pits" - sites without outdoor links
        for (int i = 0; i < sitesQuantity; i++) {
            double lastPart = 0;
            for (int l = 0; l < relations.length; l++) {
                if (l != i) {
                    if (relations[l][i] == 1) {
                        int outdoorLinks = 0;
                        for (int m = 0; m < relations[l].length; m++) {
                            if (relations[l][m] == 1) outdoorLinks++;
                        }
                        lastPart += previousPageRank[l] / outdoorLinks;
                    }
                } else {
                    int outdoorLinks = 0;
                    for (int m = 0; m < relations[l].length; m++) {
                        if (relations[l][m] == 1) outdoorLinks++;
                    }
                    if (outdoorLinks == 0) pits.add(l);
                }
            }
            pageRank[i] = (1 - dampingLevel) / sitesQuantity + dampingLevel * lastPart;
        }
        /*
          Here we distribute rank of pit site between others sites
          **/
        int quantityOfPits = pits.size();
        while (quantityOfPits > 0) {
            for (int i = 0; i < pageRank.length; i++) {
                if (!(pits.get(quantityOfPits - 1) == i))
                    pageRank[i] += previousPageRank[pits.get(quantityOfPits - 1)] / (sitesQuantity - 1);
            }
            pits.remove(quantityOfPits - 1);
            quantityOfPits = pits.size();
        }
    }

    /**
     * Fill relations arrays
     **/
    private void setRelations(int size, Scanner scanner) {
        LOGGER.info("\nWe need to set relations for each site...\n" + "if current site has link to another enter 1, if not - 0");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i != j) {
                    while (true) {
                        try {
                            LOGGER.info("Has site " + i + " link to site " + j + "?:(1 - yes, 0 - no)");
                            int enteredNumber = scanner.nextInt();
                            if (enteredNumber != 0 && enteredNumber != 1) throw new WrongNumberException();
                            relations[i - 1][j - 1] = enteredNumber;
                            break;
                        } catch (InputMismatchException e) {
                            LOGGER.warn("You entered not a number or not integer");
                            scanner.next();
                        } catch (WrongNumberException e) {
                            LOGGER.warn(e.getMessage());
                        }
                    }
                }
            }
        }
    }

    public double[] getPageRank() {
        return pageRank;
    }

    public void showPageRank() {
        LOGGER.info(Arrays.toString(pageRank));
    }

    public void showPageRelations() {
        LOGGER.info("\n" + Arrays.deepToString(relations).replace("],", "],\n"));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int sitesQuantity;
            while (true) {
                try {
                    LOGGER.info("Enter amount of sites:");
                    sitesQuantity = scanner.nextInt();
                    if (sitesQuantity < 1 || sitesQuantity > 20) throw new WrongNumberException();
                    break;

                } catch (InputMismatchException e) {
                    LOGGER.warn("You entered not a number or not integer");
                    scanner.next();
                } catch (WrongNumberException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
            MyAlgorithm algorithm = new MyAlgorithm();
            algorithm.calculatePageRank(sitesQuantity, scanner);
            algorithm.showPageRelations();
            algorithm.showPageRank();
            LOGGER.info(algorithm.sumOfRanks());
        }
    }
}
