package org.example.demo;

import java.util.ArrayList;

public class BeerData {
    // ArrayList to hold beer names
    public static final ArrayList<String> beers = new ArrayList<>();

    static {
        beers.add("Heineken");
        beers.add("Budweiser");
        beers.add("Staropramen");
        // Add more beers as needed...
    }
}