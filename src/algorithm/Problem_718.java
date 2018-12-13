package array;

import java.util.Arrays;

public class Problem_718 {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        int res = 0;
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                dp[i][j] = (A[i - 1] == B[j - 1]) ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(new Problem_718().findLength(A, B));
    }
}
