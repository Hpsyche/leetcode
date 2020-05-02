package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/2
 */
public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }

    @Test
    public void test1(){
        int[] ints = twoSum(new int[]{1,2, 7, 11, 15}, 9);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
