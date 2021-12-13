package com.adventofcode.day13;

import java.util.ArrayList;
import java.util.List;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle13 {
    private static boolean[][] marks;

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_13.txt");

        List<String> dots = inputs.subList(0, inputs.size() - 13);
        List<String> instructionList = inputs.subList(inputs.size() - 12, inputs.size());
        List<String[]> instructions = new ArrayList<>();

        for (String instruction : instructionList) {
            instructions.add(instruction.split(" ")[2].split("="));
        }

        int width = dots.stream().map(dot -> Integer.parseInt(dot.split(",")[0])).reduce(Integer::max).get() + 1;
        int height = dots.stream().map(dot -> Integer.parseInt(dot.split(",")[1])).reduce(Integer::max).get() + 1;

        marks = new boolean[height][width];

        for (String dot : dots) {
            String[] dotValues = dot.split(",");
            int horizontalVal = Integer.parseInt(dotValues[0]);
            int verticalVal = Integer.parseInt(dotValues[1]);

            marks[verticalVal][horizontalVal] = true;
        }

        boolean[][] folded = fold(marks, instructions.get(0)[0], Integer.parseInt(instructions.get(0)[1]));

        printMarks(folded);
        System.out.println(countMarks(folded));
    }

    private static void printMarks(boolean[][] marks) {
        for (boolean[] mark : marks) {
            for (boolean b : mark) {
                System.out.print(b ? "#" : ".");
            }
            System.out.print("\n");
        }
    }

    private static int countMarks(boolean[][] marks) {
        int result = 0;
        for (boolean[] mark : marks) {
            for (boolean b : mark) {
                if (b) result++;
            }
        }

        return result;
    }

    private static boolean[][] fold(boolean[][] paper, String foldBy, int number) {
        if (foldBy.equals("y")) {
            boolean[][] result = new boolean[number][paper[0].length];
            for (int i = 0; i < paper.length; ++i) {
                for (int j = 0; j < paper[i].length; ++j) {
                    if (i < number) {
                        result[i][j] = paper[i][j];
                    } else if (i > number) {
                        result[number * 2 - i][j] = paper[number * 2 - i][j] || paper[i][j];
                    }
                }
            }

            return result;
        } else if (foldBy.equals("x")) {
            boolean[][] result = new boolean[paper.length][number];
            for (int i = 0; i < paper.length; ++i) {
                for (int j = 0; j < paper[i].length; ++j) {
                    if (j < number) {
                        result[i][j] = paper[i][j];
                    } else if (j > number) {
                        result[i][number * 2 - j] = paper[i][number * 2 - j] || paper[i][j];
                    }
                }
            }

            return result;
        }

        return null;
    }
}
