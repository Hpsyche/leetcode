package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/25
 */
public class Question154 {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)>>1;
            if(nums[mid]<nums[right]){
                right=mid;
            }else if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
