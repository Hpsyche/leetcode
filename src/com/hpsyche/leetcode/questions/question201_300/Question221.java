package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/5/8
 */
public class Question221 {
    public int maximalSquare(char[][] matrix) {
            if(matrix==null||matrix.length==0||matrix[0].length==0){
                return 0;
            }
            int m=matrix.length;
            int n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        int maxWidth=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    maxWidth=Math.max(dp[i][j],maxWidth);
                }
            }
        }
        return maxWidth*maxWidth;
    }

}
