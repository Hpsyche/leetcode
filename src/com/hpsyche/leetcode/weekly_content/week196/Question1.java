package com.hpsyche.leetcode.weekly_content.week196;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/7/5
 */
public class Question1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int first=arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if((arr[i]-arr[i-1])!=first){
                return false;
            }
        }
        return true;
    }
}
