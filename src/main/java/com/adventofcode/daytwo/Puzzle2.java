package com.adventofcode.daytwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle2 {

    public static void main(String[] args) {
        // List<String> inputs = Arrays.asList("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");

        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_2.txt");

        int result = inputs.stream().map(input -> {
            String[] arr = input.split(" ");
            switch (arr[0]) {
                case "forward":
                    return new Coordinate(0, Integer.parseInt(arr[1]));
                case "up":
                    return new Coordinate(Integer.parseInt("-" + arr[1]), 0);
                default:
                    return new Coordinate(Integer.parseInt(arr[1]), 0);
            }
        }).reduce(new Coordinate(0, 0),
                (current, next) -> new Coordinate(current.x + next.x, current.y + next.y)).multipliedCoords();

        System.out.println(result);

        int result2 = inputs.stream().map(input -> {
                    String[] arr = input.split(" ");
                    switch (arr[0]) {
                        case "up":
                            return new CoordinateWithAim(0, 0, Integer.parseInt("-" + arr[1]));
                        case "down":
                            return new CoordinateWithAim(0, 0, Integer.parseInt(arr[1]));
                        default:
                            return new CoordinateWithAim(Integer.parseInt(arr[1]), 0, 0);
                    }
                }).reduce(new CoordinateWithAim(0, 0, 0),
                        (current, next) -> new CoordinateWithAim(current.horizontalPosition + next.horizontalPosition,
                                next.horizontalPosition != 0 ? current.depth + (next.horizontalPosition * current.aim) : current.depth,
                                current.aim + next.aim))
                .multiplyCoords();

        System.out.println(result2);
    }


    private static List<String> createListFromFile(String path) {
        try {
            List<String> inputs = new ArrayList<>();

            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputs.add(line);
            }
            fileReader.close();

            return inputs;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
