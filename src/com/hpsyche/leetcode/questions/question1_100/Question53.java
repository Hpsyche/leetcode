package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/22
 */
public class Question53 {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int sum=0;
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            res=Math.max(res,sum);
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));;
    }
}
