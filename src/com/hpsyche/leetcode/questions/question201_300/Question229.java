package com.hpsyche.leetcode.questions.question201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/5
 */
public class Question229 {
    /**
     * 摩尔投票法
     * 1.配对
     * 2.计数
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        int num1=nums[0];
        int count1=0;
        int num2=nums[0];
        int count2=0;
        for(int num:nums){
            if(num==num1){
                count1++;
                continue;
            }
            if(num==num2){
                count2++;
                continue;
            }
            if(count1==0){
                num1=num;
                count1++;
                continue;
            }
            if(count2==0){
                num2=num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num1==num){
                count1++;
            }else if(num2==num){
                count2++;
            }
        }
        if(count1>nums.length/3){
            res.add(num1);
        }
        if(count2>nums.length/3){
            res.add(num2);
        }
        return res;
    }
}
