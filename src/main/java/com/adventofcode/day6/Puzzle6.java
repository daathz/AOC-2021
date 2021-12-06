package com.adventofcode.day6;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle6 {

    public static void main(String[] args) {
        String inputLine = createListFromFile("src/main/resources/puzzle_input_6.txt").get(0);
        String[] inputStrings = inputLine.split(",");

        Fishes fishes = new Fishes(inputStrings);

        fishes.dayPasses(256);
    }
}
