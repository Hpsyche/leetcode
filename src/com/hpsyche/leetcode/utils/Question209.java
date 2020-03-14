package com.hpsyche.leetcode.utils;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/9
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 */
public class Question209 {
    public int minSubArrayLen(int s, int[] nums) {
        //左指针
        int i=0;
        int sum=0;
        int len=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while (sum>=s){
                len=len==0?(j-i+1):Math.min(len,j-i+1);
                sum-=nums[i++];
            }
        }
        return len;
    }

    @Test
    public void fun1(){
        System.out.println(minSubArrayLen(6,new int[]{10,2,3}));
    }
}
