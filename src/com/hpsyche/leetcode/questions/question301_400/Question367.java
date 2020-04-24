package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/3/15
 */
public class Question367 {
    public boolean isPerfectSquare(int num) {
        if(num==1 || num==0){
            return true;
        }
        for(int i=1;i<=(num>>1);i++){
            if((i*i)==num){
                return true;
            }
        }
        return false;
    }
}
