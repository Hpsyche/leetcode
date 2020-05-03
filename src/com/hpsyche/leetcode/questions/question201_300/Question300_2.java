package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question300_2 {
    public int lengthOfLIS(int[] nums) {
        int[] top=new int[nums.length];
        int num=0;
        for (int curr : nums) {
            int left = 0;
            int right = num - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (top[mid] > curr) {
                    right = mid - 1;
                } else if (top[mid] < curr) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left == num) {
                num++;
            }
            top[left] = curr;
        }
        return num;
    }

    @Test
    public void test1(){
        System.out.println(lengthOfLIS(new int[]{}));

    }
}
