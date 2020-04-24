package com.hpsyche.leetcode.questions.question1001_1100;

/**
 * @author hpsyche
 * Create on 2020/3/24
 */
public class Question1015 {
    public int smallestRepunitDivByK(int K) {
        if(K%2==0||K%5==0){
            return -1;
        }
        int n=1;
        int count=1;
        for(;n%K!=0;count++){
            n=n%K;
            n=n*10+1;
        }
        return count;
    }
}
