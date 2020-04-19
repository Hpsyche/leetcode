package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/19
 */
public class Question46 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }

    private void helper(int[] nums, ArrayList<Integer> list, boolean[] booleans) {
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            if(!booleans[i]){
                list.add(nums[i]);
                booleans[i]=true;
                helper(nums,list,booleans);
                list.remove(list.size()-1);
                booleans[i]=false;
                flag=true;
            }
        }
        if(!flag){
            res.add(new ArrayList<>(list));
        }
    }

    @Test
    public void test1(){
        List<List<Integer>> permute = permute(new int[]{1,1,2});
        for(List<Integer> temp:permute){
            for(int i:temp){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
