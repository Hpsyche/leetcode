package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author hpsyche
 * Create on 2020/6/3
 */
public class Question220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        long a;
        long b;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && j <= i + k; j++) {
                a = nums[i];
                b = nums[j];
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> treeSet=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = treeSet.ceiling((long) nums[i] - (long) t);
            if(num!=null&&num<=((long)nums[i]+(long)t)){
                return true;
            }
            treeSet.add((long)nums[i]);
            if(treeSet.size()==k+1){
                treeSet.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    @Test
    public void test(){
//        int[] nums=new int[]{1,5,9,1,5,9};
        int[] nums=new int[]{-1,2147483647};
        boolean b = containsNearbyAlmostDuplicate(nums, 1, 2147483647);
        System.out.println(b);
    }
}
