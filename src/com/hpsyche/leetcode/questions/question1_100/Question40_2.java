package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/18
 */
public class Question40_2 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] candidates, int target, int start, ArrayList<Integer> list) {
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target){
                return;
            }
            //循环在第一个1的时候已经把答案包含了,即保证了：本层不重复 但不同层可以重复
            //放在递归函数的for循环中的，使得相同递归深度的list不能添加重复，
            // [1,1,6]中的两个1不是在同一递归深度被添加的。
            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,list);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        List<List<Integer>> lists = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
