package com.hpsyche.leetcode.questions.question1_100;

/**
 * @author hpsyche
 * Create on 2020/4/26
 */
public class Question80 {
    public int removeDuplicates(int[] nums){
        int len=nums.length;
        if(len<2){
            return len;
        }
        int slow=1;
        for(int fast=2;fast<len;fast++){
            if(nums[slow-1]!=nums[fast]){
                nums[++slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
