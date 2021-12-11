package com.adventofcode.day9;

import java.util.List;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle9 {
    static int[][] field;
    static int[][] traverseMap;

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_9.txt");

        field = new int[inputs.size()][inputs.get(0).length()];
        traverseMap = new int[field.length][field[0].length];


        for (int i = 0; i < inputs.size(); ++i) {
            StringBuilder sb = new StringBuilder(inputs.get(i));
            for (int j = 0; j < sb.length(); ++j) {
                int value = Integer.parseInt(String.valueOf(sb.charAt(j)));
                field[i][j] = value;
            }
        }

        findLowPoints(field);

        int count = 0;
        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                if (traverseMap[i][j] == 1) {
                    System.out.print(field[i][j]);
                    count += field[i][j] + 1;
                }
                else System.out.print('.');
            }
            System.out.print("\n");
        }

        System.out.println(count);
    }

    private static void findLowPoints(int[][] field) {

        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[i].length; ++j) {
                checkPoint(i, j);
            }
        }
    }

    private static void checkPoint(int i, int j) {
        if (traverseMap[i][j] == -1) return;

        if (j > 0 && field[i][j - 1] <= field[i][j]) {
            traverseMap[i][j] = -1;
            return;
        }
        if (j < field[i].length - 1 && field[i][j + 1] <= field[i][j]) {
            traverseMap[i][j] = -1;
            checkPoint(i, j + 1);
            return;
        }
        if (i > 0 && field[i -1][j] <= field[i][j]) {
            traverseMap[i][j] = -1;
            return;
        }
        if (i < field.length - 1 && field[i + 1][j] <= field[i][j]) {
            traverseMap[i][j] = -1;
            checkPoint(i + 1, j);
            return;
        }

        traverseMap[i][j] = 1;
    }
}
