package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=1;
        for(int temp:dp){
            max=Math.max(temp,max);
        }
        return max;
    }

    @Test
    public void test1(){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
