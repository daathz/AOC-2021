package com.adventofcode.day6;

import java.util.List;
import java.util.stream.Collectors;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle6 {

    public static void main(String[] args) {
        String inputLine = createListFromFile("src/main/resources/puzzle_input_6.txt").get(0);
        List<String> inputStrings = List.of(inputLine.split(","));

        List<Integer> inputs = inputStrings.stream().map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < 80; ++i) {
            int newOnes = 0;
            for (int j = 0; j < inputs.size(); ++j) {
                int current = inputs.get(j);
                if (current > 0) {
                    inputs.set(j, current - 1);
                } else {
                    inputs.set(j, 6);
                    newOnes++;
                }
            }
            for (int k = 0; k < newOnes; ++k) {
                inputs.add(8);
            }
            // for (int input : inputs) {
                // System.out.print(input + ",");
            // }
            // System.out.print("\n");
        }

        System.out.println(inputs.size());
    }
}
