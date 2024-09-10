
package assn1;

import java.util.Arrays;

public class BinaryNumber {
    
    private int[] data; // Binary array
    private boolean overflow; // Overflow flag

    // Constructor with length
    public BinaryNumber(int length) {
        data = new int[length];
        Arrays.fill(data, 0); // Fill with 0s
    }

}

// Update: hw1: scaffold BinaryNumber class + string constructor
