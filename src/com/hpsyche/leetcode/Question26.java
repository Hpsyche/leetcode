package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/31
 */
public class Question26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int count=1;
        int point=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                nums[point++]=nums[i];
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println("count:"+removeDuplicates(new int[]{1,1,2,2,2,2,3,3,4,5,6}));
    }
}
