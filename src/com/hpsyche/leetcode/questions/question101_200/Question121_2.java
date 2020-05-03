package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question121_2 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        //dp[i]=max(dp[i-1],price[i]-leftMinPrice)
        int min=prices[0];
        int max=0;
        for(int price:prices){
            max=Math.max(max,price-min);
            min=Math.min(min,price);
        }
        return max;
    }

    @Test
    public void test1(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
//        System.out.println(maxProfit(new int[]{7,6,5,4,2,1}));
    }
}
