package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/10
 */
public class Question115 {
    /**
     *     0 r a b b b i t
     *  0  1 1 1 1 1 1 1 1
     *  r  0 1 1 1 1 1 1 1
     *  a  0 0 1 1 1 1 1 1
     *  !=
     *  dp[i][j]=dp[i][j-1]
     *  =
     *  dp[i][j]=dp[i][j-1]+dp[i-1][j-1]
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        int[][] dp=new int[tLen+1][sLen+1];
        for(int j=0;j<=sLen;j++){
            dp[0][j]=1;
        }
        for (int i = 1; i <= tLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[tLen][sLen];
    }

    @Test
    public void test1(){
        System.out.println(numDistinct("babgbag","bag"));
    }
}
