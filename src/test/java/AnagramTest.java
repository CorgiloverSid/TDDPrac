import org.example.Anagram;
import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class AnagramTest {
    @Test
    public void testGroupAnagram() {
        List<String> input = Arrays.asList("accompted", "compacted", "decompact", "aspire", "praise", "spirea");
        Map<String, List<String>> result = Anagram.groupAnagrams(input);

        assertEquals(2, result.values().stream().filter(g -> g.size() > 1).count());

        assertTrue(result.values().stream().anyMatch(g -> g.containsAll(Arrays.asList("accompted", "compacted", "decompact"))));
        assertTrue(result.values().stream().anyMatch(g -> g.containsAll(Arrays.asList("aspire", "praise", "spirea"))));
    }

    @Test
    public void testSingleWordAnagram() {
        List<String> input = Collections.singletonList("asset");
        Map<String, List<String>> result = Anagram.groupAnagrams(input);

        assertEquals(1, result.size());
        assertTrue(result.values().iterator().next().contains("asset"));
    }

    @Test
    public void testEmptyInputAnagram() {
        List<String> input = new ArrayList<>();
        Map<String, List<String>> result = Anagram.groupAnagrams(input);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGroupAnagramsIncludingNullAndWhitespace() {
        List<String> input = Arrays.asList("capes ", "paces ", "scape ", " space ", null, "");
        Map<String, List<String>> result = Anagram.groupAnagrams(input);

        assertEquals(1, result.values().stream().filter(g -> g.size() > 1).count());
        assertTrue(result.values().stream().anyMatch(g -> g.containsAll(Arrays.asList("capes", "paces", "scape", "space"))));
    }
}