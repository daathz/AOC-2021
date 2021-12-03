package com.adventofcode.daythree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Puzzle3 {

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_3.txt");

        int[] bitCounter = new int[12];

        for (String input : inputs) {
            for (int i = 0; i < input.length(); ++i) {
                if (input.charAt(i) == '1')
                    bitCounter[i] = bitCounter[i] + 1;
            }
        }

        String gammaRate = "000000000000";
        for (int i = 0; i < gammaRate.length(); ++i) {
            if (bitCounter[i] > 500) {
                StringBuilder sb = new StringBuilder(gammaRate);
                sb.setCharAt(i, '1');
                gammaRate = sb.toString();
            }
        }

        String omegaRate = "111111111111";
        for (int i = 0; i < omegaRate.length(); ++i) {
            if (gammaRate.charAt(i) == '1') {
                StringBuilder sb = new StringBuilder(omegaRate);
                sb.setCharAt(i, '0');
                omegaRate = sb.toString();
            }
        }

        System.out.println(Integer.parseInt(gammaRate, 2) * Integer.parseInt(omegaRate, 2));

        int oxygenGeneratorRating = Integer.parseInt(calculateOxygenGeneratorRating(0, inputs), 2);
        int co2ScrubberRating = Integer.parseInt(calculateCo2ScrubberRating(0, inputs), 2);

        System.out.println(oxygenGeneratorRating * co2ScrubberRating);
    }

    private static String calculateOxygenGeneratorRating(int index, List<String> inputs) {
        List<String> newInputs = new ArrayList<>();

        char whatToAdd = howMany(index, inputs);

        for (String input : inputs) {
            if (input.charAt(index) == whatToAdd) {
                newInputs.add(input);
            }
        }

        if (newInputs.size() == 1) {
            return newInputs.get(0);
        } else {
            return calculateOxygenGeneratorRating(index + 1, newInputs);
        }
    }

    private static String calculateCo2ScrubberRating(int index, List<String> inputs) {
        List<String> newInputs = new ArrayList<>();

        char whatToAdd = howMany(index, inputs) == '1' ? '0' : '1';

        for (String input : inputs) {
            if (input.charAt(index) == whatToAdd) {
                newInputs.add(input);
            }
        }

        if (newInputs.size() == 1) {
            return newInputs.get(0);
        } else
            return calculateCo2ScrubberRating(index + 1, newInputs);
    }

    private static char howMany(int index, List<String> inputs) {
        int countTheOnes = 0;
        for (String input : inputs) {
            if (input.charAt(index) == '1') countTheOnes++;
        }

        int divisor = inputs.size() % 2 == 0
                ? inputs.size() / 2
                : (inputs.size() / 2) + 1;

        return (countTheOnes >= divisor) ? '1' : '0';
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
