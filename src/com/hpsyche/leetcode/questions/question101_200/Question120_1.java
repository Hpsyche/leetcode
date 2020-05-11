package com.hpsyche.leetcode.questions.question101_200;

import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/5/11
 */
public class Question120_1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp=new int[triangle.size()];
        dp[0]=triangle.get(0).get(0);
        int prev=0;
        int curr;
        for(int i=1;i<triangle.size();i++){
            List<Integer> currList=triangle.get(i);
            for(int j=0;j<=i;j++){
                curr=dp[j];
                if(j==0){
                    dp[j]=curr+currList.get(j);
                }else if(i==j){
                    dp[j]=prev+currList.get(j);
                }else{
                    dp[j]=Math.min(curr,prev)+currList.get(j);
                }
                prev=curr;
            }
        }
        int res=Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
