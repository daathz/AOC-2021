package com.adventofcode.day8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle8 {

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_8.txt");

        List<List<String>> outputValuesList = inputs.stream()
                .map(input -> input.split(" \\| ")[1])
                .map(input -> input.split(" "))
                .map(List::of)
                .collect(Collectors.toList());

        // Sevent-segment display
        // args 2 means 1 is displayed
        // args 3 means 7 is displayed
        // args 4 means 4 is displayed
        // args 7 means 8 is displayed
        Integer result = outputValuesList.stream()
                .reduce(0, (subtotal, outputValues) -> subtotal + countHowMany(outputValues, 2, 3, 4, 7), Integer::sum);

        System.out.println(result);
    }

    private static int countHowMany(List<String> outputValues, int... args) {
        return Arrays.stream(args)
                .reduce(0, (subtotal, arg) ->
                        subtotal + (int) outputValues.stream().filter(i -> i.length() == arg).count());
    }
}
