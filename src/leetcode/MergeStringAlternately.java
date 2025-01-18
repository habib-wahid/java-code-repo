package leetcode;

public class MergeStringAlternately {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while ( i < word1.length() && j < word2.length()) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));

            if (i == word1.length()) {
                ans.append(word2.substring(j));
                break;
            }

            if (j == word2.length()) {
                ans.append(word1.substring(i));
                break;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
        System.out.println(mergeAlternately("ab", "pqrs"));
    }
}
