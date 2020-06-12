package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/12
 */
public class Question268 {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int sum=len*(len+1)/2;
        int temp=0;
        for(int num:nums){
            temp+=num;
        }
        return sum-temp;
    }
}
