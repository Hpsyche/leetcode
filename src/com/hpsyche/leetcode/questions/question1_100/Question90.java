package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/29
 */
public class Question90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        int size=1;
        for(int i=0;i<nums.length;i++){
            int start=0;
            if(i>0&&nums[i]==nums[i-1]){
                start=size;
            }
            size=res.size();
            for(;start<size;start++){
                List<Integer> tempList = new ArrayList<>(res.get(start));
                tempList.add(nums[i]);
                res.add(tempList);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        List<List<Integer>> lists = subsetsWithDup(new int[]{1, 2, 3});
        for(List<Integer> list:lists){
            for(int t:list){
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
}
