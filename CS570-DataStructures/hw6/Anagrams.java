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

    // Create letter to prime number mapping
    private void buildLetterTable() {
        letterTable = new HashMap<>();
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < alphabets.length; i++) {
            letterTable.put(alphabets[i], primes[i]);
        }
    }

    // Add word to anagram table
    private void addWord(String s) {
        if (s == null || s.isEmpty()) return;
        long hash = myHashCode(s);
        anagramTable.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
    }

}

// Update: hw6: MostAnagrams query
