package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/21
 */
public class Question42 {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        for (int i = 1; i < len; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max=nums[0];
        for (int i = 1; i < len; i++) {
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int len=nums.length;
        int dp0=nums[0];
        int max=nums[0];
        int dp1;
        for (int i = 1; i < len; i++) {
            dp1=Math.max(dp0+nums[i],nums[i]);
            dp0=dp1;
            max=Math.max(max,dp0);
        }
        return max;
    }

    @Test
    public void test1(){
        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
