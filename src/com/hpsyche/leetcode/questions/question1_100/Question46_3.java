package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/25
 */
public class Question46_3 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0,nums.length-1);
        return res;
    }

    private void helper(int[] nums, int start, int end) {
        if(start==end){
            List<Integer> temp=new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            res.add(temp);
        }
        for(int i=start;i<=end;i++){
            swap(nums,i,start);
            helper(nums,start+1,end);
            swap(nums,i,start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    @Test
    public void test1(){
        List<List<Integer>> lists = permute(new int[]{1,2,3,4});
        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
