package com.hpsyche.leetcode.questions.question701_800;

/**
 * @author hpsyche
 * Create on 2020/6/11
 */
public class Question739_2 {
    public int[] dailyTemperatures(int[] T) {
        int len=T.length;
        int[] dp=new int[len];
        dp[len-1]=0;
        for (int i = len-2; i >= 0; i--) {
            for (int j = i+1; j < len; j+=dp[j]) {
                if(T[i]<T[j]){
                    dp[i]=j-i;
                    break;
                }else if(dp[j]==0){
                    dp[i]=0;
                    break;
                }
            }
        }
        return dp;
    }
}