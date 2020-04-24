package com.hpsyche.leetcode.questions.question1501_1600;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/31
 */
public class Question1512 {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }


    @Test
    public void test1(){
        System.out.println(findRepeatNumber(new int[]{2,3,1,0,2,5,3}));
    }
}
