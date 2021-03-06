package com.hpsyche.leetcode.questions.question1401_1500;

/**
 * @author hpsyche
 * Create on 2020/4/23
 */
public class Question1481 {
    public int waysToChange(int n) {
        int[][] dp=new int[4][n+1];
        int[] coins={1,5,10,25};
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<4;i++){
            dp[i][0]=1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if(j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=(dp[i-1][j]+dp[i][j-coins[i]])%1000000007;
                }
            }
        }
        return dp[3][n];
    }

    public int waysToChange2(int n) {
        int[] dp=new int[n+1];
        int[] coins={1,5,10,25};
        for(int i=0;i<=n;i++){
            dp[i]=1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if(j>=coins[i]) {
                    dp[j] = (dp[j]+dp[j - coins[i]])%1000000007;
                }
            }
        }
        return dp[n];
    }
}

