package WordsTests;


import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.trie4j.patricia.PatriciaTrie;

@RunWith(Parameterized.class)
public class PatriciaTreeContainsTest {
    @Parameterized.Parameter(0)
    public int quantityOfWords;
    @Parameterized.Parameter(1)
    public int minLength;
    @Parameterized.Parameter(2)
    public int maxLength;

    PatriciaTrie patriciaTrie;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Parameterized.Parameters(name = "{index}: quantityOfWords={0}, minLength={1}, maxLength={2}")
    public static Collection<Object[]> setParameters() {
        final Collection<Object[]> params = new ArrayList<>();

        for (int i = 1; i < 25; i++) {
            for (int j = 1; j < 10; j++) {
                params.add(new Object[]{i*i, j*5, j*20});
            }
        }
        params.add(new Object[]{1000000, 500, 2000});

        return params;
    }

    @Test
    public void uniqueWordsTest() {
        final String[] words = GenerateWords.generateUniqueByteWords(quantityOfWords,minLength,maxLength);
        patriciaTrie = new PatriciaTrie(words);
        patriciaTrie.insert(words[0]);

        for (String word : words) {
            final boolean contains = patriciaTrie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void ipv4WordsTest() {
        final String[] words = GenerateWords.generateRandomIPv4(quantityOfWords);
        patriciaTrie = new PatriciaTrie(words);

        for (String word : words) {
            final boolean contains = patriciaTrie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void userAgentsTest() {
        final String[] words = GenerateWords.generateRandomUserAgents(quantityOfWords);
        patriciaTrie = new PatriciaTrie(words);

        for (String word : words) {
            final boolean contains = patriciaTrie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void randomUuidsTest() {
        final String[] words = GenerateWords.generateRandomUuids(quantityOfWords);
        patriciaTrie = new PatriciaTrie(words);

        for (String word : words) {
            final boolean contains = patriciaTrie.contains(word);

            Assert.assertTrue(contains);
        }
    }

    @Test
    public void randomStringsTest() {
        final String[] words = GenerateWords.generateRandomStrings(quantityOfWords,minLength,maxLength);
        patriciaTrie = new PatriciaTrie(words);

        for (String word : words) {
            final boolean contains = patriciaTrie.contains(word);

            Assert.assertTrue(contains);
        }
    }

}
