package com.hpsyche.leetcode.questions.question301_400;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/6/23
 */
public class Question312 {
    /**
     * dp[i][j] = x 表示，戳破气球 i 和气球 j 之间（开区间，不包括 i 和 j）的所有气球，可以获得的最高分数为 x。
     * 开区间！！！！！
     *
     *  择优做选择，使得 dp[i][j] 最大
     *     dp[i][j] = Math.max(
     *         dp[i][j],
     *         dp[i][k] + dp[k][j] + points[i]*points[j]*points[k]
     *     );
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] points = new int[len + 2];
        points[0] = 1;
        points[len + 1] = 1;
        System.arraycopy(nums, 0, points, 1, len);
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len; i >= 0; i++) {
            for (int j = i + 1; j < len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}
