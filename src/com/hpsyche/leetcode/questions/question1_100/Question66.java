package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/23
 */
public class Question66 {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            if(digits[i]<10){
                break;
            }else{
                digits[i]%=10;
            }
        }
        if(digits[0]==0){
            int[] res=new int[digits.length+1];
            res[0]=1;
            for(int i=1;i<res.length;i++){
                res[i]=0;
            }
            return res;
        }
        return digits;
    }

    @Test
    public void test1(){
        int[] ints = plusOne(new int[]{0});
        for(int i:ints){
            System.out.println(i);
        }
    }
}
