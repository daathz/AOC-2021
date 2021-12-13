package com.adventofcode.day12;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> neighbours;

    public Node(String name) {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }
}
