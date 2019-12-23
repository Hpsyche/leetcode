package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2019/12/24
 */
public class Question303 {
    private int[] preSum;
    public Question303(int[] nums) {
        preSum=new int[nums.length+1];
        preSum[0]=0;
        for(int i=1;i<=nums.length;i++){
            preSum[i]=nums[i-1]+preSum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j+1]-preSum[i];
    }

//    @Test
//    public void test1(){
//        int[] nums=new int[]{-2,0,3,-5,2,-1};
//        Question303 question303=new Question303(nums);
//        System.out.println(question303.sumRange(0,2));
//    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,0,3,-5,2,-1};
        Question303 question303=new Question303(nums);
        System.out.println(question303.sumRange(0,5));
    }
}
