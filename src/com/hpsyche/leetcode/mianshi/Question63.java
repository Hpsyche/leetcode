package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/13
 */
public class Question63 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int res=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=min){
                min=prices[i];
            }else{
                res=Math.max(res,prices[i]-min);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
