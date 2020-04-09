package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/4/9
 */
public class Question7 {
    public int reverse(int x) {
        long n=0;
        while (x!=0){
            n=n*10+x%10;
            x/=10;
        }
        return (int)n==n?(int)n:0;
    }
}
