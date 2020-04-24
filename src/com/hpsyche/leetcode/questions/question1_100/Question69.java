package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/23
 */
public class Question69 {
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
        long left=0;
        long right=x/2+1;
        while (left<right){
            //取右中位数
            long mid=(left+right+1)>>>1;
            if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return (int)left;
    }

    @Test
    public void test(){
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(5));
//        System.out.println(mySqrt(2));
//        System.out.println(mySqrt(1));
//        System.out.println(mySqrt(3));
        System.out.println(mySqrt(2147395599));
    }
}
