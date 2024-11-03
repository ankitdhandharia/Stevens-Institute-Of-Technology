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

    // Set y-coordinate
    public void setY(int y) {
        this.y = y;
    }

    // Check equality with another object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        PairInt pair = (PairInt) obj;
        return x == pair.x && y == pair.y; // Compare coordinates
    }

    // Convert coordinates to string
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Create a copy of PairInt
    public PairInt copy() {
        return new PairInt(x, y);
    }
}


// Update: hw4: submit
