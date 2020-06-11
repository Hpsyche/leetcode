package com.hpsyche.leetcode.questions.question201_300;


/**
 * @author hpsyche
 * Create on 2020/6/11
 */
public class Question263 {
    public boolean isUgly(int num) {
        if(num<1){
            return false;
        }
        while (num%5==0){
            num/=5;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%2==0){
            num/=2;
        }
        return num==1;
    }
}
