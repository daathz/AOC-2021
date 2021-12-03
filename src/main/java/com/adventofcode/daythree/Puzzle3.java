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
