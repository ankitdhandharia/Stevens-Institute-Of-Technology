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

}

// Update: hw4: Maze DFS path search
