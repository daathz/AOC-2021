package com.adventofcode.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle4 {

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_4.txt");

        List<String> drawsList = Arrays.asList(inputs.get(0).split(","));
        List<List<String>> draws = new ArrayList<>();
        int index = 0;
        while (index < drawsList.size()) {
            draws.add(drawsList.subList(index, index + 5));
            index += 5;
        }

        inputs = inputs.subList(2, inputs.size());
        List<List<String>> boardList = new ArrayList<>();
        int idx = 0;
        while (idx < inputs.size()) {
            boardList.add(inputs.subList(idx, idx + 5));
            idx += 6;
        }

        List<BingoBoard> boards = new ArrayList<>();
        for (List<String> board : boardList) {
            boards.add(new BingoBoard(board));
        }

        for (List<String> draw : draws) {
            for (String number : draw) {
                int parsedValue = Integer.parseInt(number);

                for (BingoBoard board : boards) {
                    board.markBoard(parsedValue);
                }
            }
        }
    }
}
