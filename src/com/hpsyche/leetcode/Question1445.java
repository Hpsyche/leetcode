package com.hpsyche.leetcode;

/**
 * @author hpsyche
 * Create on 2020/4/1
 */
public class Question1445 {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==nums[i]){
                return i;
            }
        }
        return -1;
    }
}
