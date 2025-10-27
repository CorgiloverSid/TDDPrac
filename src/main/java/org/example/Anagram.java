package org.example;
import java.io.*;
import java.util.*;
public class Anagram {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sido\\Desktop\\TDDPractice\\src\\main\\java\\org\\example\\words.txt";
        List<String> words = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = fileReader.readLine()) != null) {
                word = word.trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Print the anagrams, right after grouping them
        Map<String, List<String>> anagramGroups = groupAnagrams(words);
        for (List<String> group : anagramGroups.values()) {
            if (group.size() > 1) {
                System.out.println(String.join(" ", group));
            }
        }
    }

    // Sort words alphabetically and map as key value pairs
    public static Map<String, List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            if (word != null && !word.trim().isEmpty()) {
                String key = sortChars(word.trim());
                anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(word.trim());
            }
        }
        return anagramMap;
    }
    // helper method to sort words
    private static String sortChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}