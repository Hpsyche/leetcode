package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/20
 */
public class Question45_2 {
    public int jump(int[] nums) {
        int end=0;
        int count=0;
        int maxRight=0;
        for (int i = 0; i < nums.length-1; i++) {
            maxRight=Math.max(maxRight,nums[i]+i);
            if(i==end){
                count++;
                end=maxRight;
            }
        }
        return count;
    }

    @Test
    public void test1(){
//        System.out.println(jump(new int[]{1,2,1,1,1}));
//        System.out.println(jump(new int[]{1,1,1,1,1}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
