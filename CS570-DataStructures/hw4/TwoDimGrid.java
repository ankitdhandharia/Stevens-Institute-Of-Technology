/*
Homework Assignment 4: Recursion
Name: Ankit Dhandharia
*/

package Maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * TwoDimGrid is a two dimensional array of buttons.
 * Each button can be toggled between two colors by
 * clicking it with the mouse, or its color can be
 * changed/queried under program control.
 * @author Koffman and Wolfgang
 **/
public class TwoDimGrid extends JPanel implements GridColors {

    // Data Fields
    /** Prefered button size */
    private static final int PREFERED_BUTTON_SIZE = 60;
    /** Default number of rows */
    private static final int DEFAULT_COLS = 20;
    /** Default number of columns */
    private static final int DEFAULT_ROWS = 20;
    /** A two dimensional grid of buttons */
    private JButton[][] theGrid;
    /** Number of rows */
    private int nRows;
    /** Number of columns */
    private int nCols;

    // Constructors
    /**
     * Construct a TwoDimGrid of the specified size and of the
     * specified colors
     * @param nRows - Number of rows
     * @param nCols - Number of columns
     */
    public TwoDimGrid(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        setPreferredSize(new Dimension(nCols * PREFERED_BUTTON_SIZE,
                nRows * PREFERED_BUTTON_SIZE));
        setLayout(new GridLayout(nRows, nCols));
        theGrid = new JButton[nCols][];
        for (int i = 0; i != nCols; ++i) {
            theGrid[i] = new JButton[nRows];
            for (int j = 0; j != nRows; ++j) {
                theGrid[i][j] = new JButton(i + ", " + j);
                theGrid[i][j].setOpaque(true);
                theGrid[i][j].setBackground(BACKGROUND);
                theGrid[i][j].addActionListener(new ToggleColor(theGrid[i][j]));
            }
        }

        // Add the buttons to the button panel
        for (int j = 0; j != nRows; ++j) {
            for (int i = 0; i != nCols; ++i) {
                add(theGrid[i][j]);
            }
        }
    }

    // Accessors and Mutators
    /**
     * Get the number of columns
     * @return nCols */
    public int getNCols() {
        return nCols;
    }

    /**
     * Get the number of rows
     * @return nRows */
    public int getNRows() {
        return nRows;
    }

    /**
     * Get the color at a given coordinate
     * @param x - The column number
     * @param y - The row number
     * @return The color at the given coordinate */
    public Color getColor(int x, int y) {
        return theGrid[x][y].getBackground();
    }

}

// Update: hw4: MazeTest cases
