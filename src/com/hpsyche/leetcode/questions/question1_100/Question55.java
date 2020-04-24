package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/17
 */
public class Question55 {
    public boolean canJump(int[] nums) {
        int rightMax=0;
        for(int i=0;i<nums.length;i++){
            if(i<=rightMax){
                rightMax=Math.max(rightMax,i+nums[i]);
                if(rightMax>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }



    @Test
    public void test1(){
//        System.out.println(canJump(new int[]{2,}));
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

}
