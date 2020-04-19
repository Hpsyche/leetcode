package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/19
 */
public class Question46_2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, ArrayList<Integer> list) {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int num:nums){
            if(!list.contains(num)){
                list.add(num);
                backtrack(nums,list);
                list.remove(list.size()-1);
            }
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
