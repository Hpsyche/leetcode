package com.hpsyche.leetcode;

/**
 * @author hpsyche
 * Create on 2019/12/14
 */
public class Question231 {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return (n&(n-1))==0;
    }
}
