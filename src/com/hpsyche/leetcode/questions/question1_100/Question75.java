package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/25
 */
public class Question75 {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int curr=0;
        while (curr<=right){
            if(nums[curr]==0){
                swap(nums,left++,curr++);
            }else if(nums[curr]==2){
                swap(nums,right--,curr);
            }else{
                curr++;
            }
        }

        for(int i:nums){
            System.out.println(i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    @Test
    public void test1(){
        sortColors(new int[]{2,2,1,1,0});
    }
}
