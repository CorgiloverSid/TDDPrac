package org.example;
import java.io.*;
import java.util.*;
public class fastWordsFinder {
    public static void main(String[] args) throws IOException {
        Set<String> dict = loadDictionary("C:\\Users\\Sido\\Desktop\\TDDPractice\\src\\main\\java\\org\\example\\dictionary.txt");

        for (String word : dict) {
            if (word.length() != 6) continue;
            for (int i = 1; i < 6; i++) {
                if (dict.contains(word.substring(0, i)) &&
                        dict.contains(word.substring(i))) {
                    System.out.println(word.substring(0, i) + " + " + word.substring(i) + " => " + word);
                    break;
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
}
