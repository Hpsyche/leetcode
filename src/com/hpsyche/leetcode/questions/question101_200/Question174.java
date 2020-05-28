package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/28
 */
public class Question174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0){
            return -1;
        }
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] dp=new int [m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1){
                    dp[i][j]=Math.max(1,-dungeon[i][j]+1);
                }else if(i==m-1){
                    dp[i][j]=Math.max(1,dp[i][j+1]-dungeon[i][j]);
                }else if(j==n-1){
                    dp[i][j]=Math.max(1,dp[i+1][j]-dungeon[i][j]);
                }else{
                    dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
