package com.adventofcode.day7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle7 {

    public static void main(String[] args) {
        List<Integer> inputs = Stream.of(createListFromFile("src/main/resources/puzzle_input_7.txt")
                .get(0)
                .split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int median = inputs.size() % 2 == 1 ? inputs.get(inputs.size() / 2 + 1) : inputs.get(inputs.size() / 2);

        System.out.println(median);

        int countFuel = 0;
        for (int input : inputs) {
            countFuel += Math.abs(input - median);
        }

        System.out.println(countFuel);

        int average = (int) Math.floor( inputs.stream().mapToInt(i -> i).sum() / (double) inputs.size());
        System.out.println(average);

        int countFuel2 = 0;
        for (int input : inputs) {
            int distance = Math.abs(input - average);
            int sum = IntStream.range(1, distance + 1).reduce(0, Integer::sum);
            countFuel2 += sum;
        }
        System.out.println(countFuel2);
    }
}
