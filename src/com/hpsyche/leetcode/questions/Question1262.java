package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/30
 */
public class Question1262 {
    int maxSumDivThree(int[] nums){
        int length=nums.length;
        int[][] dp=new int[length+1][3];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i=1;i<=length;i++){
            if(nums[i-1]%3==0){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][0]+nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][1]+nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][2]+nums[i-1]);
            }else if(nums[i-1]%3==1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]+nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+nums[i-1]);
            }else if(nums[i-1]%3==2){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]+nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][0]+nums[i-1]);
            }
        }
        return dp[length][1];
    }

    @Test
    public void test1(){
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));

    }
}
