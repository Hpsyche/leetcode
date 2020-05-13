package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/5/13
 */
public class Question309 {
    public int maxProfit(int[] prices) {
        //dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+price[i]
        //dp[i][k][1]=max(dp[i-1][k][1],dp[i-2][k][0]-price[i]
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        int dpPrev=0;
        for (int price : prices) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dpPrev - price);
            dpPrev = temp;
        }
        return dp0;
    }

    public int maxProfit2(int[] prices) {
        //dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+price[i]
        //dp[i][k][1]=max(dp[i-1][k][1],dp[i-2][k][0]-price[i]
        int len=prices.length;
        int[][] dp=new int[len][2];
        for (int i=0;i<prices.length;i++) {
            if(i==0){
                dp[i][0]=dp[i][2]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = dp[i-1][1]+prices[i];
        }
        return Math.max(dp[len-1][0],dp[len-1][2]);
    }
}
