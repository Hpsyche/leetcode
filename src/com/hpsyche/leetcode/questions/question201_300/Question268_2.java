package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/12
 */
public class Question268_2 {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int res=len;
        for (int i = 0; i < len; i++) {
            res^=nums[i];
            res^=i;
        }
        return res;
    }
}