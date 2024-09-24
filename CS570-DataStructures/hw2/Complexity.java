/*
Assignment : Homework 2 - Complexity
Name : Ankit Dhandharia
*/

public class Complexity {
    
    static int total = 0;

    // Method 1 : Complexity with O(n^2).
    public static void method1(int n) {
        int counter = 0;
        
        if (n < 0) {
            System.out.println("\n---------------Method 1 invalid case---------------");
            System.out.println("Please enter a non-negative number as the input");
        } else {
            System.out.println("\n---------------Method 1 O(n^2)---------------");
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    counter++;
                    System.out.println("Operation " + counter);
                }
            }
        }
    }

}

// Update: hw2: algorithm 1 (nested-loop) implementation
