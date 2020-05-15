package com.hpsyche.leetcode.questions.question101_200;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/5/15
 */
public class Question132 {
    public int minCut(String s) {
        if(s==null||s.length()<=1){
            return 0;
        }
        int len=s.length();
        int[] dp=new int[len];
        Arrays.fill(dp,len-1);
        for(int i=0;i<len;i++){
            helper(s,i,i,dp);
            helper(s,i,i+1,dp);
        }
        return dp[len-1];
    }

    private void helper(String s, int i, int j, int[] dp) {
        int len=s.length();
        while (i>=0&&j<len&&s.charAt(i)==s.charAt(j)){
            // 如果以当前字符为中心的最大回文串左侧为i，右侧为j，
            // 那s[i]~s[j]长度是不需要切割的，只需要在s[i-1]处切一刀即可，
            // 即dp[i-1]+1。所以更新dp[j] = min(dp[j] , dp[i-1]+1)，不断往外扩散更新dp值取dp[i-1]即可。
            dp[j]=Math.min(dp[j],i==0?0:dp[i-1]+1);
            i--;
            j++;
        }
    }
}
