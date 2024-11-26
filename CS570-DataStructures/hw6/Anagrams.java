/*
Homework Assignment 6: Hashing
Name: Ankit Dhandharia
*/
package Assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

// Finds groups of anagrams in a dictionary
public class Anagrams {
    // First 26 prime numbers for letter encoding
    final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    // Maps letters to prime numbers
    Map<Character, Integer> letterTable;
    
    // Stores words by their hash codes
    Map<Long, ArrayList<String>> anagramTable;

    // Initialize tables
    public Anagrams() {
        buildLetterTable();
        anagramTable = new HashMap<>();
    }

}

// Update: hw6: group anagrams by signature
