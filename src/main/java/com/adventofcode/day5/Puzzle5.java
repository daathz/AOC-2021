package com.adventofcode.day5;

import java.util.List;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle5 {

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_5.txt");

        FloorMap floorMap = new FloorMap(1000);

        for (String input : inputs) {
            String[] coords = input.split(" -> ");
            String[] coord1 = coords[0].split(",");
            String[] coord2 = coords[1].split(",");

            int x1 = Integer.parseInt(coord1[0]);
            int y1 = Integer.parseInt(coord1[1]);
            int x2 = Integer.parseInt(coord2[0]);
            int y2 = Integer.parseInt(coord2[1]);

            if (x1 == x2 || y1 == y2)
                floorMap.addVents(x1, y1, x2, y2);
        }

        // System.out.println(floorMap);
        System.out.println(floorMap.countDangerousAreas());
    }
}
