package com.hpsyche.leetcode.questions.question501_600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/5/15
 */
public class Question560 {
    public int subarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int count=0;
        int len=nums.length;
        for (int left=0;left<len;left++){
            int sum=0;
            for(int right=left;right<len;right++){
                sum+=nums[right];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test1(){
//        System.out.println(subarraySum(new int[]{4,3,5,7,12,1,11},12));
        System.out.println(subarraySum(new int[]{-1,-1,1},0));
    }
}
