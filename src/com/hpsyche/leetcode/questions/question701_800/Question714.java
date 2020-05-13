package com.hpsyche.leetcode.questions.question701_800;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/13
 */
public class Question714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len=prices.length;
        int dp0=0;
        int dp1=-prices[0]-fee;
        for(int i=1;i<len;i++){
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,dp0-prices[i]-fee);
        }
        return dp0;
    }

    @Test
    public void test1(){
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
    }
}
