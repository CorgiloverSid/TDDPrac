package org.example;

import java.io.*;
import java.util.*;

public class ExtendibleWordsFinder {
    private Set<String> dict;
    private int wordsLengthAmount;

    public ExtendibleWordsFinder(Set<String> dict, int wordsLengthAmount) {
        this.dict = dict;
        this.wordsLengthAmount = wordsLengthAmount;
    }

    public List<String> findCompoundWords() {
        List<String> results = new ArrayList<>();
        for (String word : dict) {
            if (word.length() != wordsLengthAmount) {
                continue;
            }
            for (int i = 1; i < wordsLengthAmount; i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                if (dict.contains(prefix) && dict.contains(suffix)) {
                    results.add(prefix + " + " + suffix + " => " + word);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        Set<String> dictionary = loadDictionary("C:\\Users\\Sido\\Desktop\\TDDPractice\\src\\main\\java\\org\\example\\dictionary.txt");
        ExtendibleWordsFinder finder = new ExtendibleWordsFinder(dictionary, 6);
        List<String> results = finder.findCompoundWords();
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static Set<String> loadDictionary(String filename) throws IOException {
        String line;
        Set<String> words = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        while ((line = reader.readLine()) != null) {
            words.add(line.trim().toLowerCase());
        }
        reader.close();
        return words;
    }
}