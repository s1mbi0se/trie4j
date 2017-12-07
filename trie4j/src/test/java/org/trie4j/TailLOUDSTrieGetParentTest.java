package org.trie4j;

import org.trie4j.louds.TailLOUDSTrie;
import org.trie4j.louds.bvtree.LOUDSBvTree;
import org.trie4j.patricia.PatriciaTrie;
import org.trie4j.tail.SuffixTrieTailArray;

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

        final TailLOUDSTrie trie = new TailLOUDSTrie(patriciaTrie,  new LOUDSBvTree(patriciaTrie.nodeSize()), new SuffixTrieTailArray(patriciaTrie.size()));

        int nodeId = trie.getNodeId("Lucas Oliverira Bisneto");
        System.out.println(trie.getWord(nodeId));

        boolean contains = trie.contains("Lucas Oliverira Neto");
        System.out.println(contains);
    }
}
