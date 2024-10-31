/*
Homework Assignment 4: Recursion
Name: Ankit Dhandharia
*/

package Maze;

public class PairInt {
    // x-coordinate
    private int x;
    // y-coordinate
    private int y;

    // Constructor with coordinates
    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Get x-coordinate
    public int getX() {
        return x;
    }

    // Get y-coordinate
    public int getY() {
        return y;
    }

    // Set x-coordinate
    public void setX(int x) {
        this.x = x;
    }

}

// Update: hw4: backtracking + visited marking
