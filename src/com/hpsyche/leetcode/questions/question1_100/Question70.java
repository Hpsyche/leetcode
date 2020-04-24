package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/23
 */
public class Question70 {
    public int climbStairs(int n) {
        if(n<1){
            return 0;
        }
        if(n<=2){
            return n;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairs2(int n) {
        if(n<=2){
            return n;
        }
        int a=1;
        int b=1;
        for(int i=2;i<=n;i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }


    public int climbStairs3(int n) {
        if(n==1){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    @Test
    public void test1(){
        System.out.println(climbStairs3(3));
    }
}
