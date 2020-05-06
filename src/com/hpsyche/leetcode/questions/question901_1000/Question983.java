package com.hpsyche.leetcode.questions.question901_1000;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/6
 */
public class Question983 {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0 ||
                costs == null || costs.length == 0) {
            return 0;
        }
        int len=days.length;
        int[] dp=new int[days[len-1]+1];
        dp[0]=0;
        for(int day:days){
            dp[day]=Integer.MAX_VALUE;
        }
        for(int i=1;i<dp.length;i++){
            if(dp[i]==0){
                dp[i]=dp[i-1];
                continue;
            }
            int n1=dp[i-1]+costs[0];
            int n2=i>7?dp[i-7]+costs[1]:costs[1];
            int n3=i>30?dp[i-30]+costs[2]:costs[2];
            dp[i]=Math.min(n1,Math.min(n2,n3));
        }
        for(int i:dp){
            System.out.println(i);
        }
        return dp[dp.length-1];
    }

    @Test
    public void test1(){
        int i = mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15});
        System.out.println(i);
    }
}
