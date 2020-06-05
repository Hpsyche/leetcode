package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/5
 */
public class Question228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int length=nums.length;
        int start=0;
        int end=0;
        while (end<length){
            while (end<length-1&&nums[end]+1==nums[end+1]){
                ++end;
            }
            if(start==end){
                res.add(nums[end]+"");
            }else{
                res.add(nums[start]+"->"+nums[end]);
            }
            ++end;
            start=end;
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums=new int[]{3};
        List<String> list = summaryRanges(nums);
        for(String string:list){
            System.out.println(string);
        }
    }
}
