package com.example.testapp;

public class Node {
    int x;
    int y;
    String id;

    public Node(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getId() {
        return this.id;
    }
}
