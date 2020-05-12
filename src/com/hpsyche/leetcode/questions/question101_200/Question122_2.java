package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question122_2 {
    public int maxProfit(int[] prices) {
        //dp[i][0]=max(dp[i-1][0],dp[i][1]+price[i])
        //dp[i][1]=max(dp[i-1][1],dp[i-1][0]-price[i])
        int len=prices.length;
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, temp - price);
        }
        return dp0;
    }
}