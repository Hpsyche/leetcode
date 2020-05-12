package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question121_3 {
    //dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
    //dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
    //dp[-1][k][0]=dp[i][0][0]=0
    //dp[-1][k][1]=dp[i][0][1]=Integer.MIN_VALUE

    //k=1
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp_0=0;
        int dp_1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp_0=Math.max(dp_0,dp_1+prices[i]);
            dp_1=Math.max(dp_1,-prices[i]);
        }
        return dp_0;
    }
}