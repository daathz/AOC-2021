package com.adventofcode.day11;

import java.util.List;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle11 {
    static int[][] octopuses;
    static int count = 0;

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_11.txt");

        octopuses = new int[inputs.size()][inputs.get(0).length()];

        for (int i = 0; i < octopuses.length; ++i) {
            StringBuilder sb = new StringBuilder(inputs.get(i));
            for (int j = 0; j < octopuses[i].length; ++j) {
                octopuses[i][j] = Integer.parseInt(String.valueOf(sb.charAt(j)));
            }
        }

        // System.out.println(calculateFlashes(195));
        int step = 0;
        while (!checkIfSynchronized()) {
            doStep();
            step++;
        }

        System.out.println(step);
    }

    private static int calculateFlashes(int steps) {
        for (int i = 0; i < steps; ++i) {
            doStep();
        }

        return count;
    }

    private static void doStep() {
        for (int i = 0; i < octopuses.length; ++i) {
            for (int j = 0; j < octopuses[i].length; ++j) {
                octopuses[i][j] = octopuses[i][j] + 1;
            }
        }

        for (int i = 0; i < octopuses.length; ++i) {
            for (int j = 0; j < octopuses[i].length; ++j) {
                if (octopuses[i][j] == 10) flash(i ,j);
            }
        }
    }

    private static void flash(int i, int j) {
        octopuses[i][j] = 0;
        count++;

        if (j > 0) {
            if (octopuses[i][j - 1] != 0) octopuses[i][j - 1] = octopuses[i][j - 1] + 1;
            if (octopuses[i][j - 1] >= 10) flash(i, j - 1);
        }

        if (i > 0 && j > 0) {
            if (octopuses[i - 1][j - 1] != 0) octopuses[i - 1][j - 1] = octopuses[i - 1][j - 1] + 1;
            if (octopuses[i - 1][j - 1] >= 10) flash(i - 1, j - 1);
        }

        if (i > 0) {
            if (octopuses[i - 1][j] != 0) octopuses[i - 1][j] = octopuses[i - 1][j] + 1;
            if (octopuses[i - 1][j] >= 10) flash(i - 1, j);
        }

        if (i > 0 && j < octopuses[i].length - 1) {
            if (octopuses[i - 1][j + 1] != 0) octopuses[i - 1][j + 1] = octopuses[i - 1][j + 1] + 1;
            if (octopuses[i - 1][j + 1] >= 10) flash(i - 1, j + 1);
        }

        if (j < octopuses[i].length - 1) {
            if (octopuses[i][j + 1] != 0) octopuses[i][j + 1] = octopuses[i][j + 1] + 1;
            if (octopuses[i][j + 1] >= 10) flash(i, j + 1);
        }

        if (i < octopuses.length - 1 && j < octopuses[i].length - 1) {
            if (octopuses[i + 1][j + 1] != 0) octopuses[i + 1][j + 1] = octopuses[i + 1][j + 1] + 1;
            if (octopuses[i + 1][j + 1] >= 10) flash(i + 1, j + 1);
        }

        if (i < octopuses.length - 1) {
            if (octopuses[i + 1][j] != 0) octopuses[i + 1][j] = octopuses[i + 1][j] + 1;
            if (octopuses[i + 1][j] >= 10) flash(i + 1, j);
        }

        if (i < octopuses.length - 1 && j > 0) {
            if (octopuses[i + 1][j -1] != 0) octopuses[i + 1][j - 1] = octopuses[i + 1][j - 1] + 1;
            if (octopuses[i + 1][j -1] >= 10) flash(i + 1, j - 1);
        }
    }

    private static void printOctopuses() {
        for (int i = 0; i < octopuses.length; ++i) {
            for (int j = 0; j < octopuses[i].length; ++j) {
                System.out.print(octopuses[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private static boolean checkIfSynchronized() {
        for (int i = 0; i < octopuses.length; ++i) {
            for (int j = 0; j < octopuses[i].length; ++j) {
                if (octopuses[i][j] != 0) return false;
            }
        }

        return true;
    }
}
