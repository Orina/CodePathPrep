package week3.trees;

import java.util.ArrayList;

/**
 * Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.
 *
 * Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.
 *
 * You are expected to use Trie in an Interview for such problems
 *
 * Constraints:
 *
 * 1.   1 <= No.of reviews <= 200
 * 2.   1 <= No. of words in a review <= 1000
 * 3.   1 <= Length of an individual review <= 10,000
 * 4.   1 <= Number of Good Words <= 10,000
 * 5.   1 <= Length of an individual Good Word <= 4
 * 6.   All the alphabets are lower case (a - z)
 * Input:
 *
 * S : A string S containing "Good Words" separated by  "_" character. (See example below)
 * R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
 * Output:
 *
 * A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.
 *
 * V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
 * In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
 * Example:
 *
 * Input:
 * S = "cool_ice_wifi"
 * R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]
 *
 * Output:
 * ans = [2, 0, 1]
 * Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class HotelReviews {

    /**
     * Construct a trie based on a collection of good words
     *
     * for each review:
     * count how many hits it have in trie
     * store the pair {index of the review, hits count} in the list
     *
     * sort the list of pairs based on hits count using insertion sort
     *
     * traverse the list of pairs and return the result
     */
    public class Trie {
        public static final int R = 26;
        public TrieNode root = new TrieNode();

        public void add(String word) {
            root = add(root, 0, word);
        }

        public boolean contains(String word) {
            TrieNode trieNode = get(root, 0, word);
            return trieNode != null && trieNode.isWord;
        }

        private TrieNode add(TrieNode node, int d, String word) {
            if (node == null) {
                node = new TrieNode();
            }
            if (d == word.length()) {
                node.isWord = true;
                return node;
            }
            char ch = word.charAt(d);
            node.next[ch - 'a'] = add(node.next[ch - 'a'], d + 1, word);
            return node;
        }

        private TrieNode get(TrieNode node, int d, String word) {
            if (node == null) return null;
            if (d == word.length()) {
                return node;
            }
            char ch = word.charAt(d);
            return get(node.next[ch - 'a'], d + 1, word);
        }
    }

    public class TrieNode {
        boolean isWord = false;
        TrieNode[] next = null;

        public TrieNode() {
            next = new TrieNode[Trie.R];
        }
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        if (B == null || B.size() == 0) return new ArrayList<Integer>();

        int N = B.size();
        Trie trie = new Trie();

        for (String word : A.split("_")) {
            trie.add(word);
        }

        Pair[] array = new Pair[N];
        for (int i = 0; i < N; i++) {
            String[] reviewWords = B.get(i).split("_");
            int hits = 0;
            for (String reviewWord : reviewWords) {
                if (trie.contains(reviewWord)) {
                    hits++;
                }
            }
            array[i] = new Pair(i, hits);
        }

        // sort array by hits in decreasing order using insertion sort
        for (int i = 1; i < N; i++) {
            int j = i;
            while (j > 0 && array[j - 1].value < array[j].value) {
                swap(array, j - 1, j);
                j--;
            }
        }

        ArrayList<Integer> result = new ArrayList();
        for (Pair pair : array) result.add(pair.index);
        return result;
    }

    private void swap(Pair[] array, int i, int j) {
        Pair tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static class Pair {
        int index;
        int value;

        public Pair(int a, int b) {
            this.index = a;
            this.value = b;
        }
    }
}