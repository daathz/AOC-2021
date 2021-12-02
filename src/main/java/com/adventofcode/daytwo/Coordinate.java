package com.adventofcode.daytwo;

class Coordinate {
    int x;
    int y;

    Coordinate() {
        x = 0;
        y = 0;
    }

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int multipliedCoords() {
        return x * y;
    }
}
