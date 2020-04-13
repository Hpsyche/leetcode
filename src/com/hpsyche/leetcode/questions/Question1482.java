package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/13
 */
public class Question1482 {
    int trailingZeroes(int n){
        int count=0;
        while(n>4){
            count+= n/=5;
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(trailingZeroes(5));
    }
}
