package algorithm;

import java.util.Arrays;

public class Problem_538 {
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for(int[] n : memo)
            Arrays.fill(n, -1);
        int res = f(word1, word2, 0, 0);
        return word1.length() + word2.length() - 2 * res;
    }

    private int f(String word1, String word2, int i, int j) {
        if(i >= word1.length() || j >= word2.length())
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j))
        {
            memo[i][j] = 1 + f(word1, word2, i+1, j+1);
            return memo[i][j];
        }
        memo[i][j] = Math.max(f(word1, word2, i+1, j),
                f(word1, word2, i, j+1));
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Problem_538().minDistance("", "eat"));
    }
}
