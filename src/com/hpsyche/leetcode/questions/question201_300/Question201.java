package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/4
 */
public class Question201 {
    public int rangeBitwiseAnd(int m, int n) {
        int i=0;
        while (m!=n){
            m>>=1;
            n>>=1;
            i++;
        }
        return m<<i;
    }

    @Test
    public void test1(){
        System.out.println(rangeBitwiseAnd(5,7));
    }
}
