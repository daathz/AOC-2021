package com.adventofcode.day10;

import java.util.List;
import java.util.Stack;

import static com.adventofcode.helper.InputReaderUtil.createListFromFile;

public class Puzzle10 {

    public static void main(String[] args) {
        List<String> inputs = createListFromFile("src/main/resources/puzzle_input_10.txt");

        int count = 0;

        for (String input : inputs) {
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
                        count += 3;
                        break;
                    }
                } else if (sb.charAt(i) == ']') {
                    Character pop = stack.pop();
                    if (pop != ']') {
                        count += 57;
                        break;
                    }
                } else if (sb.charAt(i) == '}') {
                    Character pop = stack.pop();
                    if (pop != '}') {
                        count += 1197;
                        break;
                    }
                } else if (sb.charAt(i) == '>') {
                    Character pop = stack.pop();
                    if (pop != '>') {
                        count += 25137;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
