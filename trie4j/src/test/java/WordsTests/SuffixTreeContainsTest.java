package WordsTests;


import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.trie4j.louds.TailLOUDSTrie;
import org.trie4j.louds.bvtree.LOUDSBvTree;
import org.trie4j.patricia.PatriciaTrie;
import org.trie4j.tail.SuffixTrieTailArray;

@RunWith(Parameterized.class)
public class SuffixTreeContainsTest {
    @Parameterized.Parameter(0)
    public int quantityOfWords;
    @Parameterized.Parameter(1)
    public int minLength;
    @Parameterized.Parameter(2)
    public int maxLength;

    PatriciaTrie patriciaTrie;

    @Parameterized.Parameters(name = "{index}: quantityOfWords={0}, minLength={1}, maxLength={2}")
    public static Collection<Object[]> setParameters() {
        final Collection<Object[]> params = new ArrayList<>();

        for (int i = 1; i < 25; i++) {
            for (int j = 1; j < 10; j++) {
                params.add(new Object[]{i * i, j * 5, j * 20});
            }
        }

        return params;
    }

    private static void highQuantity(final Collection<Object[]> params) {
        params.add(new Object[]{145, 50, 100});
        params.add(new Object[]{131, 50, 100});
        params.add(new Object[]{131, 49, 100});
        params.add(new Object[]{10000, 5, 15});
        params.add(new Object[]{10000, 50, 100});
        params.add(new Object[]{10000, 200, 300});
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void uniqueWordsTest() {
        final String[] words = GenerateWords.generateUniqueByteWords(quantityOfWords, minLength, maxLength);
        patriciaTrie = new PatriciaTrie(words);

        final TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie,
                new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));

        for (String word : words) {
            final boolean contains = trie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void ipv4WordsTest() {
        final String[] words = GenerateWords.generateRandomIPv4(quantityOfWords);
        patriciaTrie = new PatriciaTrie(words);

        final TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie,
                new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));

        for (String word : words) {
            final boolean contains = trie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void userAgentsTest() {
        final String[] words = GenerateWords.generateRandomUserAgents(quantityOfWords);
        patriciaTrie = new PatriciaTrie(words);

        final TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie,
                new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));

        for (String word : words) {
            final boolean contains = trie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void randomUuidsTest() {
        final String[] words = GenerateWords.generateRandomUuids(quantityOfWords);
        patriciaTrie = new PatriciaTrie(words);

        final TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie,
                new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));

        for (String word : words) {
            final boolean contains = trie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void randomStringsTest() {
        final String[] words = GenerateWords.generateRandomStrings(quantityOfWords, minLength, maxLength);
        patriciaTrie = new PatriciaTrie(words);

        final TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie,
                new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));

        for (String word : words) {
            final boolean contains = trie.contains(word);

            Assert.assertTrue(contains);
        }
    }
}
