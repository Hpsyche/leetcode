package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/3/21
 */
public class Question392 {
    public boolean isSubsequence(String s, String t) {
        int sLength=s.length();
        int tLength=t.length();
        int[][] dp=new int[sLength+1][tLength+1];
        for(int i=0;i<=sLength;i++){
            dp[i][0]=0;
        }
        for (int j = 0; j <= tLength; j++) {
            dp[0][j]=0;
        }
        for(int i=1;i<=sLength;i++){
            for(int j=1;j<=tLength;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[sLength][tLength] == s.length();
    }
}
