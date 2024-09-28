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

    // Method 5 : Complexity with O(log log(n))
    public static void method5(int n) {
        int counter = 0;
        
        if (n < 2) {
            System.out.println("\n---------------Method 5 invalid case---------------");
            System.out.println("Please enter a positive number greater than 1 as the input");
        } else {
            System.out.println("\n---------------Method 5 O(log log(n))---------------");
            
            for (double i = 2; i < n; i = i * i) {
                counter++;
                System.out.println("Operation " + counter);
            }
        }
    }

    // Method 6 : Complexity with O(2^n)
    public static void method6(int n) {
        if (n < 0) {
            System.out.println("\n---------------Method 6 invalid case---------------");
            System.out.println("Please enter a non-negative number as the input");
        } else {
            System.out.println("\n---------------Method 6 O(2^n)---------------");
            
            int counter = 1;
            for (int i = 1; i <= n; i++) {
                counter *= 2;
            }
            
            for (int i = 1; i <= counter; i++) {
                System.out.println("Operation " + i);
            }
        }
    }

}

// Update: hw2: Big-O analysis write-up in comments
