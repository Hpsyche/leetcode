package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/6/11
 */
public class Question264 {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n];
        ugly[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        for (int i = 1; i < n; i++) {
            int factor2=2*ugly[index2];
            int factor3=3*ugly[index3];
            int factor5=5*ugly[index5];
            int min= Math.min(factor2,Math.min(factor3,factor5));
            ugly[i]=min;
            if(factor2==min){
                index2++;
            }
            if(factor3==min){
                index3++;
            }
            if(factor5==min){
                index5++;
            }
        }
        return ugly[n-1];
    }

    @Test
    public void test1(){
        System.out.println(nthUglyNumber(10));
    }
}
