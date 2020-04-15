package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/15
 */
public class Question27 {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        for(int i=len-1;i>=0;i--){
            if(nums[i]==val){
                len--;
                for(int j=i;j<len;j++){
                    nums[j]=nums[j+1];
                }
            }
        }
        return len;
    }

    @Test
    public void test1(){
        System.out.println(removeElement(new int[]{},122));
    }
}
