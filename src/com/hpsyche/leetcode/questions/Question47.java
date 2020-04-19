package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/19
 */
public class Question47 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(nums,new ArrayList<Integer>(),new boolean[nums.length]);
        return res;
    }

    private void helper(int[] nums, ArrayList<Integer> list, boolean[] booleans) {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(booleans[i]){
                continue;
            }
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if(i>0&&nums[i]==nums[i-1]&&!booleans[i-1]){
                continue;
            }
            list.add(nums[i]);
            booleans[i]=true;
            helper(nums,list,booleans);
            list.remove(list.size()-1);
            booleans[i]=false;
        }
    }

    @Test
    public void test1(){
        List<List<Integer>> permute = permuteUnique(new int[]{1,1,2});
        for(List<Integer> temp:permute){
            for(int i:temp){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
