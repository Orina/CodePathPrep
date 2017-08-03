package week3.trees;

import java.util.ArrayList;

/**
 * Find shortest unique prefix to represent each word in the list.
 *
 * Example:
 *
 * Input: [zebra, dog, duck, dove]
 * Output: {z, dog, du, dov}
 * where we can see that
 * zebra = z
 * dog = dog
 * duck = du
 * dove = dov
 * NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 *
 * https://www.interviewbit.com/problems/shortest-unique-prefix/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class ShortestUniquePrefix {

    /**
     * Every trie node contains a counter - to summarize how many words contain this character
     *
     * Construct a trie based on list of string: increment a counter in every processed node
     *
     * for each word find the unique prefix in trie = the node where count is equal to 1
     */
    public ArrayList<String> prefix(ArrayList<String> a) {

        Trie trie = new Trie();

        for (String str : a) {
            trie.add(str);
        }
        ArrayList<String> result = new ArrayList();
        for (String str : a) {
            result.add(trie.getUniquePrefix(str));
        }
        return result;
    }

    class Trie {
        Node root;
        public int R = 26;

        public Trie() {
            root = new Node();
        }

        public void add(String s) {
            root = add(root, s, 0);
        }

        public String getUniquePrefix(String s) {
            return getUniquePrefix(root, s, 0, "");
        }

        private Node add(Node node, String s, int d) {
            if (d == s.length()) return node;

            if (node == null) {
                node = new Node();
                node.count = 1;
            } else node.count++;

            char c = s.charAt(d);
            node.next[c - 'a'] = add(node.next[c - 'a'], s, d + 1);
            return node;
        }

        private String getUniquePrefix(Node node, String s, int d, String prefix) {
            if (s.length() == d) return s;
            if (node.count == 1) return prefix;

            char c = s.charAt(d);
            return getUniquePrefix(node.next[c - 'a'], s, d + 1, prefix + c);
        }
    }

    class Node {
        int count = 0;
        Node[] next;

        public Node() {
            this.count = 0;
            next = new Node[26];
        }
    }
}