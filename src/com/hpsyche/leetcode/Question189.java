package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/12
 */
public class Question189 {
    public void rotate(int[] nums, int k) {
        if(nums.length<2){
            return;
        }
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    @Test
    public void test(){
        int[] res=new int[]{1,2,3,4,5,6,7};
        rotate(res,3);
        for(int temp:res){
            System.out.println(temp);
        }
    }
}
