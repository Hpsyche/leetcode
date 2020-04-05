package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/13
 */
public class Question365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 && y == 0) {
            return z == 0;
        }
        return z == 0 || (z % gcd(x,y) == 0 && x + y >= z);
    }

    private int gcd(int x, int y) {
        if(x==0){
            return y;
        }
        if(y==0){
            return x;
        }
        int min=Math.min(x,y);
        for(int i=min;i>0;i--){
            if(x%i==0&&y%i==0){
                return i;
            }
        }
        return 1;
    }

    @Test
    public void test(){
        System.out.println(gcd(0,2));
    }

}
