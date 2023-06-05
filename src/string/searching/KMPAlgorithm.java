package string.searching;

import java.util.ArrayList;
import java.util.List;
/*
Kmp Algorithm

The KMP algorithm creates a partial match table, which stores the length of the longest proper prefix of the pattern that is also a suffix of the pattern.
This table is used to determine the next character to compare in the text after a mismatch occurs, rather than restarting the comparison from the beginning
of the pattern.

The KMP algorithm has a time complexity of O(n+m), where n is the length of the text and m is the length of the pattern. This makes it more efficient than
brute-force algorithms, which have a worst-case time complexity of O(nm).

The KMP algorithm is widely used in string matching, including in bioinformatics, text editors, and compilers.
* */
public class KMPAlgorithm {
    public static int[] buildPartialMatchTable(String pattern) {
        int[] partialMatchTable = new int[pattern.length()];
        int i = 0, j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                partialMatchTable[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    partialMatchTable[j] = 0;
                    j++;
                } else {
                    i = partialMatchTable[i-1];
                }
            }
        }
        return partialMatchTable;
    }

    public static List<Integer> search(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int[] partialMatchTable = buildPartialMatchTable(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    indices.add(i - j);
                    j = partialMatchTable[j-1];
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = partialMatchTable[j-1];
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";
        String pattern = "The";
        List<Integer> indices = search(text, pattern);
        System.out.println("Pattern found at indices: " + indices);
    }
}

