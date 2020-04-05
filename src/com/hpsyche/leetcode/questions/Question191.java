package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/3/12
 */
public class Question191 {
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            if((n&1)==1){
                count++;
            }
            //无符号右移，避免负数的情况
            n=n>>>1;
        }
        return count;
    }

    public int weight2(int n){
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
