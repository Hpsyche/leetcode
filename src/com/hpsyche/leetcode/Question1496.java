package com.hpsyche.leetcode;

/**
 * @author hpsyche
 * Create on 2020/3/24
 */
public class Question1496 {
    public int massage(int[] nums) {
        //0：第n个不接
        // dp[n][0]:第n-1个接/不接都可以，dp[n][0]=max(dp[n-1][0],dp[n-1][1])
        //1:第n个接
        // dp[n][0]:第n-1个不能接，dp[n][1]=dp[n-1][0]+nums[i]
        int dp0=0;
        int dp1=nums[0];
        for(int i=1;i<nums.length;++i){
            int sumDp0=Math.max(dp0,dp1);
            int sumDp1=dp0+nums[i];
            dp0=sumDp0;
            dp1=sumDp1;
        }
        return Math.max(dp0,dp1);
    }

    public int massage2(int[] nums) {
        //递推方程：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
