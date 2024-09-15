
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

    // Shift right
    public void shiftR(int amount) {
        data = Arrays.copyOf(data, data.length + amount); // Resize
        
        // Shift digits
        for (int i = data.length - 1; i >= amount; i--) {
            data[i] = data[i - amount];
        }
        
        Arrays.fill(data, 0, amount, 0); // Fill with 0s
    }

    // Add two binary numbers
    public void add(BinaryNumber other) {
        if (data.length != other.getLength()) {
            System.out.println("Lengths do not match");
            return;
        }

        int[] otherData = other.getBinary(); // Get other data
        int carry = 0;

        // Binary addition
        for (int i = data.length - 1; i >= 0; i--) {
            int sum = carry + data[i] + otherData[i];
            data[i] = sum % 2;
            carry = sum / 2;
        }
        
        overflow = (carry > 0); // Set overflow
    }

    // Get binary array
    private int[] getBinary() {
        return data;
    }

    // Convert to string
    @Override
    public String toString() {
        if (overflow) {
            return "Overflow";
        }
        
        StringBuilder sb = new StringBuilder(); // Build string
        
        // Append digits
        for (int digit : data) {
            sb.append(digit);
        }
        return sb.toString();
    }

    // Clear overflow
    public void clearOverflow() {
        overflow = false;
    }

}

// Update: hw1: add UML class diagram
