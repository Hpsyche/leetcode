package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/17
 */
public class Question33 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        while (left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<nums[right]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            } else{
                if(nums[left]<=target&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test1(){
        System.out.println(search(new int[]{3,5,1},3));
    }
}
