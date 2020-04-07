package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/7
 */
public class Question674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int left=0;
        int right=1;
        int maxLength=0;
        while (right<nums.length){
            int temp=nums[left];
            while (right<nums.length&&nums[right]>temp) {
                temp = nums[right];
                right++;
                maxLength = Math.max(right - left, maxLength);
            }
            maxLength=Math.max(right-left,maxLength);
            left=right;
            right++;
        }
        return maxLength;
    }

    @Test
    public void test1(){
        int lengthOfLCIS = findLengthOfLCIS(new int[]{2,2,2,2,2});
        System.out.println(lengthOfLCIS);

    }
}
