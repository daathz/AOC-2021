package com.adventofcode.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle10 {

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_10.txt");

        int syntaxErrorScore = 0;

        List<Long> autoCompleteList = new ArrayList<>();

        for (String input : inputs) {
            boolean hasError = false;
            StringBuilder sb = new StringBuilder(input);
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < sb.length(); ++i) {
                if (sb.charAt(i) == '(') stack.push(')');
                else if (sb.charAt(i) == '[') stack.push(']');
                else if (sb.charAt(i) == '{') stack.push('}');
                else if (sb.charAt(i) == '<') stack.push('>');
                else if (sb.charAt(i) == ')') {
                    Character pop = stack.pop();
                    if (pop != ')') {
                        syntaxErrorScore += 3;
                        hasError = true;
                        break;
                    }
                } else if (sb.charAt(i) == ']') {
                    Character pop = stack.pop();
                    if (pop != ']') {
                        syntaxErrorScore += 57;
                        hasError = true;
                        break;
                    }
                } else if (sb.charAt(i) == '}') {
                    Character pop = stack.pop();
                    if (pop != '}') {
                        syntaxErrorScore += 1197;
                        hasError = true;
                        break;
                    }
                } else if (sb.charAt(i) == '>') {
                    Character pop = stack.pop();
                    if (pop != '>') {
                        syntaxErrorScore += 25137;
                        hasError = true;
                        break;
                    }
                }
            }

            if (!hasError) {
                long autoCompleteScore = 0;
                while (!stack.empty()) {
                    autoCompleteScore *= 5;
                    Character pop = stack.pop();
                    if (pop == ')') autoCompleteScore += 1;
                    else if (pop == ']') autoCompleteScore += 2;
                    else if (pop == '}') autoCompleteScore += 3;
                    else if (pop == '>') autoCompleteScore += 4;

                }

                autoCompleteList.add(autoCompleteScore);
            }

        }

        Collections.sort(autoCompleteList);

        System.out.println(autoCompleteList.get(autoCompleteList.size() / 2));

        // System.out.println(syntaxErrorScore);
    }
}
