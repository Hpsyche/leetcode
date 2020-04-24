package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/20
 */
public class Question44_2 {
    public boolean isMatch(String s, String p) {
        int sLen=s.length();
        int pLen=p.length();
        boolean[][] dp=new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for(int i=1;i<=pLen;i++){
            dp[0][i]=dp[0][i-1]&&p.charAt(i-1)=='*';
        }
        for(int i=1;i<=sLen;i++){
            for (int j = 1; j <= pLen; j++) {
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]|dp[i][j-1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    @Test
    public void test1(){
        System.out.println(isMatch("adceb","*a*b"));
    }
}
