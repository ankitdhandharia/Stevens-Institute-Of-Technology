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

    // Method 2 : Complexity with O(n^3)
    public static void method2(int n) {
        int counter = 0;
        
        if (n < 0) {
            System.out.println("\n---------------Method 2 invalid case---------------");
            System.out.println("Please enter a non-negative number as the input");
        } else {
            System.out.println("\n---------------Method 2 O(n^3)---------------");
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        counter++;
                        System.out.println("Operation " + counter);
                    }
                }
            }
        }
    }

    // Method 3 : Complexity with O(log(n))
    public static void method3(int n) {
        int counter = 0;
        
        if (n < 0) {
            System.out.println("\n---------------Method 3 invalid case---------------");
            System.out.println("Please enter a positive number as the input");
        } else {
            System.out.println("\n---------------Method 3 O(log(n))---------------");
            
            for (int i = 1; i < n; i = i * 2) {
                counter++;
                System.out.println("Operation " + counter);
            }
        }
    }

    // Method 4 : Complexity with O(n log(n))
    public static void method4(int n) {
        int counter = 0;
        
        if (n < 0) {
            System.out.println("\n---------------Method 4 invalid case---------------");
            System.out.println("Please enter a positive number as the input");
        } else {
            System.out.println("\n---------------Method 4 O(n log(n))---------------");
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < n; j = j * 2) {
                    counter++;
                    System.out.println("Operation " + counter);
                }
            }
        }
    }

}

// Update: hw2: algorithm 3
