/*
Homework Assignment 4: Recursion
Name: Ankit Dhandharia
*/

package Maze;

import java.util.ArrayList;
import java.util.Stack;

public class Maze implements GridColors {

    // Maze grid
    private TwoDimGrid maze;

    // Constructor with grid parameter
    public Maze(TwoDimGrid m) {
        maze = m;
    }

    // Find path from start point
    public boolean findMazePath() {
        return findMazePath(0, 0);
    }

    // Recursive method for maze path
    public boolean findMazePath(int x, int y) {
        // Outside grid check
        if (x < 0 || y < 0 || x >= maze.getNCols() || y >= maze.getNRows()) {
            return false;
        }
        // Not a valid path check
        if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
            return false;
        }
        // Exit cell check
        if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, PATH); // Mark as path
            return true;
        }

        maze.recolor(x, y, PATH); // Mark as path

        // Recursive calls for neighbors
        if (findMazePath(x + 1, y) || findMazePath(x, y + 1) ||
            findMazePath(x - 1, y) || findMazePath(x, y - 1)) {
            return true;
        }

        maze.recolor(x, y, TEMPORARY); // Mark as visited
        return false;
    }

    // Find all possible paths
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>(); // List of paths
        Stack<PairInt> trace = new Stack<>(); // Current path stack
        findMazePathStackBased(x, y, result, trace);
        return result;
    }

}

// Update: hw4: backtracking + visited marking
