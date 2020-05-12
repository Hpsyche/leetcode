package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question123_2 {

    //dp[i][2][0]=max(dp[i-1][2][0],dp[i-1][2][1]+price[i])
    //dp[i][2][1]=max(dp[i-1][2][1],dp[i-1][1][0]-price[i])
    //dp[i][1][0]=max(dp[i-1][1][0],dp[i-1][1][1]+price[i])
    //dp[i][1][1]=max(dp[i-1][1][1],-price[i])

    public int maxProfit(int[] prices) {
        int dpi10=0;
        int dpi11=Integer.MIN_VALUE;
        int dpi20=0;
        int dpi21=Integer.MIN_VALUE;
        for (int price : prices) {
            dpi20 = Math.max(dpi20, dpi21 + price);
            dpi21 = Math.max(dpi21, dpi10 - price);
            dpi10 = Math.max(dpi10, dpi11 + price);
            dpi11 = Math.max(dpi11, -price);
        }
        return dpi20;
    }
}