package array;

import java.util.Arrays;

public class Problem_714 {
    private int[][] memo;
    public int maxProfit(int[] prices, int fee) {
        memo = new int[prices.length][2];
        for(int[] n : memo)
            Arrays.fill(n, -1);
        return helper(prices, fee, 0, 0);
    }
    private int helper(int[] prices, int fee, int start, int hasStock){
        if(start >= prices.length)
            return 0;
        if(memo[start][hasStock] != -1)
            return memo[start][hasStock];
        int res;
        if(hasStock == 1)
        {
            res = Math.max(prices[start] - fee + helper(prices, fee, start+1, 0),
                    helper(prices, fee, start+1, 1));
            memo[start][hasStock] = res;
            return res;
        }
        res = Math.max(-prices[start] + helper(prices, fee, start+1, 1),
                helper(prices, fee, start+1, 0));
        memo[start][hasStock] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        System.out.println(new Problem_714().maxProfit(prices, 2));
    }
}
