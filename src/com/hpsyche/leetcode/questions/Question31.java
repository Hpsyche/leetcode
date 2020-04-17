package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/16
 */
public class Question31 {
    public void nextPermutation(int[] nums) {
        int j=nums.length-1;
        while (j>=1&&nums[j-1]>=nums[j]){
            j--;
        }
        //无下一个
        if(j==0){
            for(int i=0;i<nums.length/2;i++){
                swap(nums,i,nums.length-1-i);
            }
            return;
        }
        int r=nums.length-1;
        while (r>=j){
            if(nums[r]<nums[j]){
                break;
            }
            r--;
        }
        swap(nums,r,j-1);
        for(int i=0;i<(nums.length-j)/2;i++){
            swap(nums,j+i,nums.length-i-1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    @Test
    public void test1(){
        nextPermutation(new int[]{0,5,4,3,2,1});
    }
}
