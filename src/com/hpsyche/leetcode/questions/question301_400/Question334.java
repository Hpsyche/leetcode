package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/7/7
 */
public class Question334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int small=Integer.MAX_VALUE;
        int mid=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=small){
                small=num;
            }else if(num<=mid){
                mid=num;
            }else {
                return true;
            }
        }
        return false;
    }
}
