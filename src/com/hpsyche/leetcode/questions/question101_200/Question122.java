package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question122 {
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                res+=(prices[i]-prices[i-1]);
            }
        }
        return res;
    }
}
