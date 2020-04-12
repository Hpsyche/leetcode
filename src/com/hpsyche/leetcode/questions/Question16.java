package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/4/12
 */
public class Question16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            if(i==0||nums[i]!=nums[i+1]){
                int l=i+1;
                int r=nums.length-1;
                while (l<r){
                    int temp=nums[l]+nums[r]+nums[i];
                    if(Math.abs(temp-target)<Math.abs(ans-target)){
                        ans=temp;
                    }
                    if(temp>target){
                        r--;
                    }else if(temp<target){
                        l++;
                    }else{
                        return temp;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
