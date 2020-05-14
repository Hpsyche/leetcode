package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/5/14
 */
public class Question128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int count=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currNum=num;
                int currCount=1;
                while (set.contains(currNum+1)){
                    currNum++;
                    currCount++;
                }
                count=Math.max(count,currCount);
            }
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
