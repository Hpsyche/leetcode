package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/7/8
 */
public class Question16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if(shorter==longer){
            return new int[]{k*shorter};
        }
        int[] res=new int[k+1];
        int basic=shorter*k;
        res[0]=basic;
        int incr=longer-shorter;
        for (int i = 1; i <= k; i++) {
            res[i]=res[i-1]+incr;
        }
        return res;
    }

    @Test
    public void test1(){
        int[] ints = divingBoard(1, 2, 0);
        for(int i:ints){
            System.out.println(i);
        }
    }
}
