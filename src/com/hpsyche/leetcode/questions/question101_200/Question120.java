package com.hpsyche.leetcode.questions.question101_200;

import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/5/11
 */
public class Question120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int x=triangle.size();
        int y=triangle.get(x-1).size();
        int[][] dp=new int[x][y];
        dp[0][0]=triangle.get(0).get(0);
        for (int i = 1; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                } else if(i==j){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < y; i++) {
            res = Math.min(res, dp[y - 1][i]);
        }
        return res;
    }
}
