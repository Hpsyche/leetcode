package com.hpsyche.leetcode.questions.question1401_1500;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/13
 */
public class Question1429 {
    public int multiply(int A, int B) {
        return computer(Math.max(A,B),Math.min(A,B));
    }

    private int computer(int max, int min) {
        if(min==1){
            return max;
        }
        if(min==2){
            return max+max;
        }
        if((min%2)==0){
            return computer(max,min>>1)<<1;
        }else{
            return max+computer(max,min-1);
        }
    }

    public int multiply2(int A, int B) {
        if(B==1){
            return A;
        }
        return A+multiply(A,B-1);
    }



    @Test
    public void test(){
        System.out.println(multiply2(9,6));
    }
}
