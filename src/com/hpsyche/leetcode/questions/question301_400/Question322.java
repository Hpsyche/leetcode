package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question322 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[i]=amount+1;
        }
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin<=i){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

    @Test
    public void test1(){
//        System.out.println(coinChange(new int[]{2,5,10,1},27));
        System.out.println(coinChange(new int[]{2},3));

    }
}
