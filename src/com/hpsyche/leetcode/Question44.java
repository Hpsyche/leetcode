package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/15
 */
public class Question44 {
    public int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        int num=0;
        int count=0;
        for(;n>=0;count++){
            num=n;
            n-=Math.pow(10,count)*9*(count+1);
        }
        int a=(num-1)/count;
        int b=(num-1)%count;
        a=(int)(Math.pow(10,count-1)+a);
        return String.valueOf(a).charAt(b)-'0';
    }

    @Test
    public void test1(){

        System.out.println(findNthDigit(19));
    }
}
