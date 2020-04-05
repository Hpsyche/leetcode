package com.hpsyche.leetcode.weekly_content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/5
 */
public class Question5376 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int temp=0;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        for(int i=nums.length-1;i>=0;i--){
            list.add(nums[i]);
            temp+=nums[i];
            if(temp>(sum-temp)){
                return list;
            }
        }
        return list;
    }
}
