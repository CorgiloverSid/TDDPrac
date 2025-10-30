package org.example;
import java.io.*;
import java.util.*;

public class readableWordsFinder {
    public static void main(String[] args) throws IOException {
        Set<String> dict = loadDictionary("dict.txt");
        List<String> sixLetterWords = getSixLetterWords(dict);

        for (String word : sixLetterWords) {
            for (int i = 1; i < 6; i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                if (dict.contains(prefix) && dict.contains(suffix)) {
                    System.out.println(prefix + " + " + suffix + " => " + word);
                }
            }
        }
    }

    private static Set<String> loadDictionary(String filename) throws IOException {
        String line;
        Set<String> words = new HashSet<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));

        while ((line = fileReader.readLine()) != null) {
            words.add(line.trim().toLowerCase());
        }
        fileReader.close();
        return words;
    }

    private static List<String> getSixLetterWords(Set<String> dictionary) {
        List<String> sixLetterWordResult = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() == 6) {
                sixLetterWordResult.add(word);
            }
        }
        return sixLetterWordResult;
    }
}
