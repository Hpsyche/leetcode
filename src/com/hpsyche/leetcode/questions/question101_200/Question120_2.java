package com.hpsyche.leetcode.questions.question101_200;

import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/5/11
 */
public class Question120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> rows=triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+rows.get(j);
            }
        }
        return dp[0][0];
    }
}
