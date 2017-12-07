package WordsTests;

import org.trie4j.Node;
import org.trie4j.Trie;
import org.trie4j.louds.TailLOUDSTrie;
import org.trie4j.louds.bvtree.LOUDSBvTree;
import org.trie4j.patricia.PatriciaTrie;
import org.trie4j.tail.SuffixTrieTailArray;
import org.trie4j.util.Pair;

import java.util.Objects;

public class TailLOUDSTrieGetParentTest {
    public static void main(String[] args) {
        Trie patriciaTrie = new PatriciaTrie();
        patriciaTrie.insert("Ana Clara");
        patriciaTrie.insert("Ana Silva");
        patriciaTrie.insert("Rafael Telles");
        patriciaTrie.insert("Rafael Bastos");
        patriciaTrie.insert("Lucas Amin");
        patriciaTrie.insert("Lucas Oliverira");
        patriciaTrie.insert("Lucas Oliverira Filho");
        patriciaTrie.insert("Lucas Oliverira Junior");
        patriciaTrie.insert("Lucas Oliverira Neto");
        patriciaTrie.insert("Lucas Oliverira Bisneto");

        TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie, new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));
        Iterable<Pair<String, Integer>> x = trie.predictiveSearchWithNodeId("");
        for (Pair<String, Integer> stringIntegerPair : x) {
            final String expected = stringIntegerPair.getFirst();
            final String got = trie.getWord(stringIntegerPair.getSecond());

            if (!Objects.equals(expected, got)) {
                System.err.println("ERROR!");
                System.exit(1);
            }
        }
    }
}
