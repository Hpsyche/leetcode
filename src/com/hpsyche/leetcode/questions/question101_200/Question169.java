package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question169 {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int count=1;
        int countNum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==countNum){
                count++;
            }else{
                if(count>0) {
                    count--;
                }else{
                    countNum=nums[i];
                    count=1;
                }
            }
        }
        return countNum;
    }

    @Test
    public void test1(){
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2,2,1}));
    }
}
