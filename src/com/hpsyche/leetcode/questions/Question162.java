package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/4/8
 */
public class Question162 {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
