package com.adventofcode.day2;

public class CoordinateWithAim {
    int horizontalPosition;
    int depth;
    int aim;

    public CoordinateWithAim(int horizontalPosition, int depth, int aim) {
        this.horizontalPosition = horizontalPosition;
        this.depth = depth;
        this.aim = aim;
    }

    public int multiplyCoords() {
        return horizontalPosition * depth;
    }
}
