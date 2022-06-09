package com.solvd.page_rank.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            MySite site = objectMapper.readValue(new File("src/main/resources/sites/site1.json"), MySite.class);
            System.out.println(site);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
