package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/3/26
 */
public class Question371 {
    public int getSum(int a, int b) {
        int sum=a^b;
        int carry=a&b;
        if(carry!=0){
            return getSum(sum,(carry)<<1);
        }
        return sum;
    }
}
