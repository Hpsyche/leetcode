package com.hpsyche.leetcode.mianshi;

/**
 * @author hpsyche
 * Create on 2020/6/2
 */
public class Question64 {
    int res;
    public int sumNums(int n){
        boolean x=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
