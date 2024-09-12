
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

    // Constructor with string
    public BinaryNumber(String str) {
        if (!str.matches("[01]+")) { // Check binary
            System.out.println("Not a Binary Number");
            return;
        }
        
        data = new int[str.length()]; // Init array
        
        // Convert string to binary
        for (int i = 0; i < str.length(); i++) {
            data[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    // Get length
    public int getLength() {
        return data.length;
    }

    // Get digit by index
    public int getDigit(int index) {
        if (index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    // Convert to decimal
    public int toDecimal() {
        int decimal = 0;
        
        // Binary to decimal
        for (int i = 0; i < data.length; i++) {
            decimal += data[i] * Math.pow(2, data.length - i - 1);
        }
        return decimal;
    }

}

// Update: hw1: toString + decimal conversion
