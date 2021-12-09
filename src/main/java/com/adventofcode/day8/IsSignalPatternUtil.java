package com.adventofcode.day8;

public class IsSignalPatternUtil {

    public static boolean isSignalPatternOf9(String s, String signalPatternOf4, String signalPatternOf7) {
        boolean isCorrectLength = s.length() == 6;

        int countMatches = 0;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb4 = new StringBuilder(signalPatternOf4);
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (sb.charAt(j) == sb4.charAt(i)) countMatches++;
            }
        }
        boolean matchesWith4 = countMatches == 4;

        countMatches = 0;
        StringBuilder sb7 = new StringBuilder(signalPatternOf7);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (sb.charAt(j) == sb7.charAt(i)) countMatches++;
            }
        }
        boolean matchesWith7 = countMatches == 3;

        return isCorrectLength && matchesWith4 && matchesWith7;
    }

    public static boolean isSignalPatternOf3(String s, String signalPatternOf1) {
        boolean isCorrectLength = s.length() == 5;

        int countMatches = 0;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb1 = new StringBuilder(signalPatternOf1);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (sb.charAt(j) == sb1.charAt(i)) countMatches++;
            }
        }
        boolean matchesWith1 = countMatches == 2;

        return isCorrectLength && matchesWith1;
    }

    public static boolean isSignalPatternOf0(String s, String signalPatternOf3, String signalPatternOf4, String signalPatternOf1) {
        boolean isCorrectLength = s.length() == 6;

        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb3 = new StringBuilder(signalPatternOf3);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (sb.charAt(j) == sb3.charAt(i)) result.append(sb.charAt(j));
            }
        }

        StringBuilder result1 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder(signalPatternOf4);
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < result.length(); ++j) {
                if (result.charAt(j) == sb4.charAt(i)) result1.append(result.charAt(j));
            }
        }

        if (result1.length() != 2) return  false;

        int count = 0;
        StringBuilder sb1 = new StringBuilder(signalPatternOf1);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < result1.length(); ++j) {
                if (result1.charAt(j) == sb1.charAt(i)) count++;
            }
        }

        return isCorrectLength && count == 2;
    }

    public static boolean isSignalPatternOf6(String s, String signalPatternOf9, String signalPatternOf0) {
        return s.length() == 6 && !s.equals(signalPatternOf9) && !s.equals(signalPatternOf0);
    }

    public static boolean isSignalPatternOf5(String s, String signalPatternOf6) {
        boolean isCorrectLength = s.length() == 5;

        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb6 = new StringBuilder(signalPatternOf6);

        int count = 0;
        for (int i = 0; i < sb6.length(); ++i) {
            for (int j = 0; j < sb.length(); ++j) {
                if (sb.charAt(j) == sb6.charAt(i)) count++;
            }
        }

        return isCorrectLength && count == 5;
    }

    public static boolean isSignalPatternOf2(String s, String signalPatternOf3, String signalPatternOf5) {
        return s.length() == 5 && !s.equals(signalPatternOf3) && !s.equals(signalPatternOf5);
    }
}
