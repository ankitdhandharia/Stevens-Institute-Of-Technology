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

    // Helper method for all paths
    private void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
        // Outside grid or invalid path
        if (x < 0 || y < 0 || x >= maze.getNCols() || y >= maze.getNRows() || !maze.getColor(x, y).equals(NON_BACKGROUND)) {
            return;
        }

        trace.push(new PairInt(x, y)); // Add to path

        // Check for exit cell
        if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            result.add(new ArrayList<>(trace)); // Add path to result
        } else {
            maze.recolor(x, y, PATH); // Mark as path
            // Recursive calls for neighbors
            findMazePathStackBased(x + 1, y, result, trace);
            findMazePathStackBased(x, y + 1, result, trace);
            findMazePathStackBased(x - 1, y, result, trace);
            findMazePathStackBased(x, y - 1, result, trace);
            maze.recolor(x, y, NON_BACKGROUND); // Reset color
        }

        trace.pop(); // Remove from path
    }

    // Find shortest path in maze
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
        ArrayList<ArrayList<PairInt>> allPaths = findAllMazePaths(x, y); // All paths list
        ArrayList<PairInt> minPath = null; // Shortest path

        // Compare path lengths
        for (ArrayList<PairInt> path : allPaths) {
            if (minPath == null || path.size() < minPath.size()) {
                minPath = path;
            }
        }
        return minPath != null ? minPath : new ArrayList<>();
    }

    // Reset temporary cells to background
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }

}

// Update: hw4: UML + refactor
