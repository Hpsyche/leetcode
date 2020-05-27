package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/27
 */
public class Question172 {
    public int trailingZeroes(int n) {
        int res=0;
        while(n/5!=0){
            res+=n/5;
            n/=5;
        }
        return res;
    }
}
