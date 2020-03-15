package com.hpsyche.leetcode;

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
