package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/13
 */
public class Question18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            //第一次还是需要放行的
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int newTarget=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                //第一次还是需要放行的
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int newTarget2=newTarget-nums[j];
                int left=j+1;
                int right=nums.length-1;
                while (left<right){
                    if(nums[left]+nums[right]==newTarget2){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]<newTarget2){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        List<List<Integer>> lists = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for(List<Integer> tempList:lists){
            for(int temp:tempList){
                System.out.print(temp);
            }
            System.out.println();
        }
    }

}