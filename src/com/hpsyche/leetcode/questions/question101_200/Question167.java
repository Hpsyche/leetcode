package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/27
 */
public class Question167 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while (l<r){
            int sum=numbers[l]+numbers[r];
            if(sum==target){
                return new int[]{l+1,r+1};
            }else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return null;
    }

    @Test
    public void test1(){
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints[0]);
    }
}
