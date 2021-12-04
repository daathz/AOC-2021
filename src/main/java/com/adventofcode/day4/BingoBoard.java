package com.adventofcode.day4;

import java.util.ArrayList;
import java.util.List;

public class BingoBoard {
    private int[][] values;
    private boolean[][] checked;

    public BingoBoard(List<String> inputs) {
        values = new int[5][5];
        checked = new boolean[5][5];

        for (int i = 0; i < 5; ++i) {
            String[] line = inputs.get(i).trim().split("\\s+");
            for (int j = 0; j < 5; ++j) {
                values[i][j] = Integer.parseInt(line[j]);
                checked[i][j] = false;
            }
        }
    }

    public boolean markBoard(int number) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (values[i][j] == number) {
                    checked[i][j] = true;

                    if (checkIfBoardWins()) {
                        System.out.println(calculateFinalScore(number));
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean checkIfBoardWins() {
        //rows
        for (int i = 0; i < 5; ++i) {
            int countChecked = 0;
            for (int j = 0; j < 5; ++j) {
                if (checked[i][j]) countChecked++;
            }
            if (countChecked == 5) return true;
        }

        // columns
        for (int i = 0; i < 5; ++i) {
            int countChecked = 0;
            for (int j = 0; j < 5; ++j) {
                if (checked[j][i]) countChecked++;
            }
            if (countChecked == 5) return true;
        }

        return false;
    }

    private int calculateFinalScore(int number) {
        int sum = 0;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (!checked[i][j]) {
                    sum += values[i][j];
                }
            }
        }

        return sum * number;
    }
}
