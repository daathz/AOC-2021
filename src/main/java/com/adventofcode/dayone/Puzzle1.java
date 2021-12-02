package com.adventofcode.dayone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Puzzle1 {

    public static void main(String[] args) {

        // int count = calculateIncreasedDepthMeasurements(Arrays.asList("199", "200", "208", "210", "200", "207", "240", "269", "260", "263"));

        List<Integer> measurements = createListFromFile("src/main/resources/puzzle_input_1.txt");
        List<Integer> threeWindowMeasurements = createSlidingWindowFromList(measurements, 3);

        System.out.println(calculateIncreasedDepthMeasurements(measurements));
        System.out.println(calculateIncreasedDepthMeasurements(threeWindowMeasurements));
    }

    private static List<Integer> createListFromFile(String path) {
        try {
            List<Integer> inputs = new ArrayList<>();

            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputs.add(Integer.valueOf(line));
            }
            fileReader.close();

            return inputs;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static List<Integer> createSlidingWindowFromList(List<Integer> inputList, int windowSize) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputList.size() - windowSize + 1; ++i) {
            int addedValue = 0;
            for (int j = 0; j < windowSize; ++j) {
                addedValue += inputList.get(i + j);
            }
            result.add(addedValue);
        }

        return result;
    }

    private static int calculateIncreasedDepthMeasurements(List<Integer> inputs) {
        int count = 0;
        Integer previousValue = null;

        if (inputs != null) {
            for (Integer input : inputs) {
                if (previousValue == null) {
                    previousValue = input;
                } else {
                    int currentValue = input;
                    if (currentValue > previousValue) {
                        count++;
                    }
                    previousValue = currentValue;
                }
            }
        }

        return count;
    }
}
