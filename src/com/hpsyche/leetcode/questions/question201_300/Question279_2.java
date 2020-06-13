package com.hpsyche.leetcode.questions.question201_300;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/6/13
 */
public class Question279_2 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
