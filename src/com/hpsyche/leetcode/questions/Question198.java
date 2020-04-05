package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/3/24
 */
public class Question198 {
    public int rob(int[] nums) {
        //dp[n]=max(dp[n-1],dp[n-2]+nums[n]
        int len=nums.length;
        if(len<1){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        int[] dp=new int[len];
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1),dp),
                myRob(Arrays.copyOfRange(nums,1,nums.length),dp));
    }

    private int myRob(int[] nums, int[] dp) {
        int len=nums.length;
        if(len<1){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }

    @Test
    public void test1(){
        System.out.println(rob(new int[]{2,3,2}));
    }
}
