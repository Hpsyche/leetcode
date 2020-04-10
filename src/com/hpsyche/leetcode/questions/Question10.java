package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/10
 */
public class Question10 {
    public boolean isMatch(String s, String p) {

        int sLen=s.length();
        int pLen=p.length();
        boolean[][] dp=new boolean[pLen+1][sLen+1];
        dp[0][0]=true;
        //第一列需要处理，如果上格为*，且上上格为true，则dp值为true
        for(int i=2;i<=pLen;i++){
            dp[i][0]=(dp[i-2][0]&&p.charAt(i-1)=='*');
        }
        for(int i=1;i<=pLen;i++) {
            for (int j = 1; j <= sLen; j++) {
                if (p.charAt(i - 1) == '*') {
                    if (dp[i - 1][j] || (i > 1 && dp[i - 2][j])) {
                        dp[i][j] = true;
                    }
                    else if (i > 1 && (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.')) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    if (((p.charAt(i - 1) == s.charAt(j - 1)) || (p.charAt(i - 1) == '.')) && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[pLen][sLen];
    }

    @Test
    public void test1(){
        System.out.println(isMatch("",".*"));
    }
}
