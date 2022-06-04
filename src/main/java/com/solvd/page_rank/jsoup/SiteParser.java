package com.solvd.page_rank.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SiteParser {

    public static void parseHtmlForHref(String site) {

        site = "http://www.google.com/";

        try {
            Document doc = Jsoup.connect(site).get();
            Element mBody = doc.body();
            String name = doc.title();
            System.out.println("Name of page html: " + name);

            Elements urls = mBody.getAllElements();

            for (Element url : urls) {

                if (!url.attr("href").isEmpty())
                    System.out.println("\nhref " + url.attr("href"));
                // needs to write to file or db
            }
        } catch (IOException e) {
        }

    }
}