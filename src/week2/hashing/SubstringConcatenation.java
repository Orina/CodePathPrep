package week2.hashing;

import java.math.BigInteger;
import java.util.*;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 *
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 * Example :
 *
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * https://www.interviewbit.com/problems/substring-concatenation/
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        int kBase = 26;
        //long kMod = longRandomPrime();
        long kMod = 9997;
        long powerS = 1;

        //length of text
        int n = a.length();
        //length of single word
        int w = b.get(0).length();
        //length of the full search string
        int wordsCount = b.size();
        int m = w * wordsCount;

        if (n < m) return new ArrayList();

        long hashText = 0;
        long hashPat = 0;

        for (int i = 1; i < w; i++) {
            powerS = (powerS * kBase) % kMod;
        }

        List<Long> hashWordsList = new ArrayList<>();
        HashMap<String, Integer> keywords = new HashMap();

        for (int i = 0; i < wordsCount; i++) {
            long curWordHash = 0;
            long textWordHash = 0;
            for (int j = 0; j < w; j++) {
                curWordHash = (curWordHash * kBase + (b.get(i).charAt(j))) % kMod;
                textWordHash = (textWordHash * kBase + (a.charAt(i * w + j))) % kMod;
            }
            hashWordsList.add(textWordHash % kMod);
            hashPat = (hashPat + curWordHash) % kMod;
            hashText = (hashText + textWordHash) % kMod;

            if (!keywords.containsKey(b.get(i))) {
                keywords.put(b.get(i), 1);
            } else {
                keywords.put(b.get(i), keywords.get(b.get(i)) + 1);
            }
        }


        ArrayList<Integer> result = new ArrayList();
        for (int i = 1; i <= n - m; i++) {
            if (hashText == hashPat && isEqualWords(a.substring(i - 1, i - 1 + m), w,
                    wordsCount, keywords)) {
                result.add(i - 1);
            }
            hashText = 0;
            for (int j = 0; j < wordsCount; j++) {
                long wordHash = hashWordsList.get(j);
                int wordStartIdx = i + j * w - 1;
                int wordEndIdx = wordStartIdx + w;

                wordHash = (wordHash - powerS * (a.charAt(wordStartIdx)) % kMod) % kMod;
                if (wordHash < 0) wordHash += kMod;
                wordHash = (wordHash * kBase + (a.charAt(wordEndIdx))) % kMod;

                hashText = (hashText + wordHash) % kMod;
                hashWordsList.set(j, wordHash);
            }
        }

        if (hashText == hashPat) result.add(n - m);
        return result;
    }

    private boolean isEqualWords(String str, int w, int n, HashMap<String, Integer> keywords) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            String word = str.substring(i * w, (i + 1) * w);
            if (!keywords.containsKey(word)) return false;
            if (!map.containsKey(word)) map.put(word, 1);
            else map.put(word, map.get(word) + 1);
        }
        for (String key : keywords.keySet()) {
            if (map.containsKey(key)) {
                int count = map.get(key);
                count--;
                if (count == 0) map.remove(key);
                else {
                    map.put(key, count);
                }
            }
        }
        return map.isEmpty();
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }


    public static void main(String[] args) {
        String text = "bcabbcaabbccacacbabccacaababcbb";
        List<String> list = Arrays.asList("c", "b", "a", "c", "a", "a", "a", "b", "c");
        new SubstringConcatenation().findSubstring(text, list);
    }

    public ArrayList<Integer> findSubstringBruteForce(String s, final List<String> words) {
        ArrayList<Integer> result = new ArrayList<>();
        int unitSize = words.get(0).length();
        int concatLength = words.size() * unitSize;

        Map<String, Integer> dictionary = new HashMap<>();
        for (String word : words) addToDictionary(word, dictionary);

        for (int i = 0; i + concatLength <= s.length(); i++) {
            if (matchAllWordsInDictionary(s, dictionary, i, words.size(), unitSize)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean matchAllWordsInDictionary(String s, Map<String, Integer> dictionary, int start, int numWords, int unitSize) {
        Map<String, Integer> currDictionary = new HashMap<>();
        for (int i = 0; i < numWords; i++) {
            String curWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            if (!dictionary.containsKey(curWord)) return false;
            addToDictionary(curWord, currDictionary);
            if (currDictionary.get(curWord) > dictionary.get(curWord)) return false;
        }
        return true;
    }

    private void addToDictionary(String word, Map<String, Integer> dictionary) {
        if (dictionary.containsKey(word)) {
            dictionary.put(word, dictionary.get(word) + 1);
        } else dictionary.put(word, 1);
    }

}