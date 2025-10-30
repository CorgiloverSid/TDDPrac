import org.example.ExtendibleWordsFinder;
import org.junit.Test;
import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordsFinderTest {

    @Test
    public void testFindWords() {
        Set<String> dict = new HashSet<>(Arrays.asList(
                "al", "bums", "albums", "bar", "ely", "barely"
        ));
        ExtendibleWordsFinder finder = new ExtendibleWordsFinder(dict, 6);
        List<String> results = finder.findCompoundWords();

        assertTrue(results.contains("al + bums => albums"));
        assertTrue(results.contains("bar + ely => barely"));
        assertEquals(2, results.size());
    }

    @Test
    public void testNoMatchingWords() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("Teddy", "Beard", "Jail"));
        ExtendibleWordsFinder finder = new ExtendibleWordsFinder(dictionary, 6);
        List<String> results = finder.findCompoundWords();

        assertTrue(results.isEmpty());
    }
}