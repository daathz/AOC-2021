package com.adventofcode.day8;

import java.util.Arrays;
import java.util.List;

import static com.adventofcode.day8.IsSignalPatternUtil.*;
import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle8 {

    // TODO 0 and 9 are replaced !!!!!
    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_8.txt");

//        List<List<String>> outputValuesList = inputs.stream()
//                .map(input -> input.split(" \\| ")[1])
//                .map(input -> input.split(" "))
//                .map(List::of)
//                .collect(Collectors.toList());

        // Sevent-segment display
        // args 2 means 1 is displayed
        // args 3 means 7 is displayed
        // args 4 means 4 is displayed
        // args 7 means 8 is displayed
        // Integer result = outputValuesList.stream()
               // .reduce(0, (subtotal, outputValues) -> subtotal + countHowMany(outputValues, 2, 3, 4, 7), Integer::sum);

        // System.out.println(result);

        int result = 0;
        for (String input : inputs) {
            System.out.println(getOutputValues(input));
            result += getOutputValues(input);
        }
        System.out.println(result);
    }

    private static int countHowMany(List<String> outputValues, int... args) {
        return Arrays.stream(args)
                .reduce(0, (subtotal, arg) ->
                        subtotal + (int) outputValues.stream().filter(i -> i.length() == arg).count());
    }

    private static int getOutputValues(String input) {
        String[] signalPatterns = input.split(" \\| ")[0].split(" ");
        String[] encodedOutputValues = input.split(" \\| ")[1].split(" ");

        String signalPatternOf1 = Arrays.stream(signalPatterns).filter(s -> s.length() == 2).findFirst().get();
        String signalPatternOf4 = Arrays.stream(signalPatterns).filter(s -> s.length() == 4).findFirst().get();
        String signalPatternOf7 = Arrays.stream(signalPatterns).filter(s -> s.length() == 3).findFirst().get();
        String signalPatternOf8 = Arrays.stream(signalPatterns).filter(s -> s.length() == 7).findFirst().get();

        String signalPatternOf9 = Arrays.stream(signalPatterns)
                .filter(s -> isSignalPatternOf9(s, signalPatternOf4, signalPatternOf7)).findFirst().get();
        String signalPatternOf3 = Arrays.stream(signalPatterns)
                .filter(s -> isSignalPatternOf3(s, signalPatternOf1)).findFirst().get();

        String signalPatternOf0 = Arrays.stream(signalPatterns)
                .filter(s -> isSignalPatternOf0(s, signalPatternOf3, signalPatternOf4, signalPatternOf1)).findFirst().get();
        String signalPatternOf6 = Arrays.stream(signalPatterns)
                .filter(s -> isSignalPatternOf6(s, signalPatternOf9, signalPatternOf0)).findFirst().get();
        String signalPatternOf5 = Arrays.stream(signalPatterns)
                .filter(s -> isSignalPatternOf5(s, signalPatternOf6)).findFirst().get();
        String signalPatternOf2 = Arrays.stream(signalPatterns)
                .filter(s -> isSignalPatternOf2(s, signalPatternOf3, signalPatternOf5)).findFirst().get();

        int[] digits = new int[4];

        for (int i = 0; i < encodedOutputValues.length; ++i) {
            if (encodedOutputValues[i].length() == 2) {
                digits[i] = 1;
            } else if (encodedOutputValues[i].length() == 4) {
                digits[i] = 4;
            } else if (encodedOutputValues[i].length() == 3) {
                digits[i] = 7;
            } else if (encodedOutputValues[i].length() == 7) {
                digits[i] = 8;
            } else if (encodedOutputValues[i].length() == 5) {
                int count = 0;
                StringBuilder sb = new StringBuilder(encodedOutputValues[i]);
                StringBuilder sb2 = new StringBuilder(signalPatternOf2);
                for (int j = 0; j < 5; ++j) {
                    for (int k = 0; k < 5; ++k) {
                        if (sb.charAt(j) == sb2.charAt(k)) count++;
                    }
                }
                if (count == 5) {
                    digits[i] = 2;
                    continue;
                }

                count = 0;
                StringBuilder sb5 = new StringBuilder(signalPatternOf5);
                for (int j = 0; j < 5; ++j) {
                    for (int k = 0; k < 5; ++k) {
                        if (sb.charAt(j) == sb5.charAt(k)) count++;
                    }
                }
                if (count == 5) {
                    digits[i] = 5;
                    continue;
                }

                count = 0;
                StringBuilder sb3 = new StringBuilder(signalPatternOf3);
                for (int j = 0; j < 5; ++j) {
                    for (int k = 0; k < 5; ++k) {
                        if (sb.charAt(j) == sb3.charAt(k)) count++;
                    }
                }
                if (count == 5) {
                    digits[i] = 3;
                }
            } else {
                int count = 0;
                StringBuilder sb = new StringBuilder(encodedOutputValues[i]);
                StringBuilder sb6 = new StringBuilder(signalPatternOf6);
                for (int j = 0; j < 6; ++j) {
                    for (int k = 0; k < 6; ++k) {
                        if (sb.charAt(j) == sb6.charAt(k)) count++;
                    }
                }
                if (count == 6) {
                    digits[i] = 6;
                    continue;
                }

                count = 0;
                StringBuilder sb9 = new StringBuilder(signalPatternOf9);
                for (int j = 0; j < 6; ++j) {
                    for (int k = 0; k < 6; ++k) {
                        if (sb.charAt(j) == sb9.charAt(k)) count++;
                    }
                }
                if (count == 6) {
                    digits[i] = 9;
                    continue;
                }

                count = 0;
                StringBuilder sb0 = new StringBuilder(signalPatternOf0);
                for (int j = 0; j < 6; ++j) {
                    for (int k = 0; k < 6; ++k) {
                        if (sb.charAt(j) == sb0.charAt(k)) count++;
                    }
                }
                if (count == 6) {
                    digits[i] = 0;
                }
            }
        }

        return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
    }
}
