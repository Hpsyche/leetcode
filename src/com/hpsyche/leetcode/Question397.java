package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/15
 */
public class Question397 {
    public int integerReplacement(int n) {
        return getReplace(n);
    }

    private int getReplace(int n) {
        if(n==1){
            return 0;
        }
        if(n%2==0){
            return 1+getReplace(n/2);
        }else{
            return 1+Math.min(getReplace(n+1),getReplace(n-1));
        }
    }

    @Test
    public void fun1(){
        System.out.println(integerReplacement(7));
    }
}
