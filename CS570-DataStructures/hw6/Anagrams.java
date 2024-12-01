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

    // Generate hash code for word using prime numbers
    private Long myHashCode(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid input word");
        }
        long key = 1;
        for (char c : s.toCharArray()) {
            key *= letterTable.get(c);
        }
        return key;
    }

    // Read words from file into anagram table
    private void processFile(String filename) throws IOException {
        try (FileInputStream fStream = new FileInputStream(filename);
             BufferedReader br = new BufferedReader(new InputStreamReader(fStream))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                this.addWord(strLine);
            }
        }
    }

    // Find entries with most anagrams
    private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
        ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
            int size = entry.getValue().size();
            if (size > max) {
                maxEntries.clear();
                maxEntries.add(entry);
                max = size;
            } else if (size == max) {
                maxEntries.add(entry);
            }
        }
        return maxEntries;
    }

    // Process dictionary and display results
    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        final long startTime = System.nanoTime();
        
        try {
            a.processFile("words_alpha.txt");
        } catch (IOException e1) {
            System.out.println("Error processing file: " + e1.getMessage());
            return;
        }

        ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
        if (maxEntries.isEmpty()) {
            System.out.println("No anagrams found.");
            return;
        }

        long key = maxEntries.get(0).getKey();
        int length = maxEntries.get(0).getValue().size();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime / 1_000_000_000);
        
        System.out.println("Elapsed Time: " + seconds);
        System.out.println("Key of maximum anagrams: " + key);
        System.out.println("List of max anagrams: " + maxEntries.get(0).getValue());
        System.out.println("Length of list of max anagrams: " + length);
    }
}

// Update: hw6: UML + submit
