package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/3/12
 */
public class Question190 {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<=31;i++){
            res=res+=((1&(n>>i))<<(n-i));
        }
        return res;
    }
}
