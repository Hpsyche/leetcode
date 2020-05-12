package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question123 {
    public int maxProfit(int[] prices) {
        int maxK=2;
        int len=prices.length;
        if(len<=1){
            return 0;
        }
        int[][][] dp=new int[len][maxK+1][2];
        for (int i = 0; i < len; i++) {
            for(int k=maxK;k>=1;k--){
                if(i==0){
                    dp[0][k][0]=0;
                    dp[0][k][1]=-prices[i];
                    continue;
                }
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[len-1][maxK][0];
    }
}
