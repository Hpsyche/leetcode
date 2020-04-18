package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/18
 */
public class Question35 {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    @Test
    public void test1(){
        int i = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);
    }

}
