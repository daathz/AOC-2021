package com.adventofcode.day6;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Fishes {
    Map<Integer, Long> fishes;

    public Fishes(String[] inputs) {
        fishes = new HashMap<>();
        for (int i = 0; i < 9; ++i) {
            fishes.put(i, 0L);
        }

        for (String input : inputs) {
            int val = Integer.parseInt(input);
            long currentSize = fishes.get(val);
            fishes.put(val, ++currentSize);
        }
    }

    public void dayPasses(int days) {
        for (int i = 0; i < days; ++i) {
            Map<Integer, Long> newFishes = new HashMap<>();
            for (int j = 0; j < 9; ++j) {
                if (j != 6 && j != 8) {
                    newFishes.put(j, fishes.get(j+1));
                } else if (j == 8) {
                    newFishes.put(j, fishes.get(0));
                } else {
                    newFishes.put(j, fishes.get(0) + fishes.get(7));
                }
            }
            fishes = newFishes;
        }
        System.out.println(size());
    }

    private BigDecimal size() {
        BigDecimal count = new BigDecimal(0);
        for (long sameAgeSize : fishes.values()) {
            count = count.add(new BigDecimal(sameAgeSize));
        }
        return count;
    }
}
