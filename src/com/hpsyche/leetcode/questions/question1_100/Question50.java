package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/21
 */
public class Question50 {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        double res=1;
        double curr=x;
        for(long i=N;i>0;i/=2){
            if((i%2)==1){
                res*=curr;
            }
            curr=curr*curr;
        }
        return res;
    }

    @Test
    public void test1(){
        double v = myPow(2.0, 12);
        System.out.print(v);
    }
}
