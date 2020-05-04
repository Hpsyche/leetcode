package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/4
 * 最长回文串（即最长公共子串，翻转过来了），需要加一步判断
 */
public class Question5_2 {
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        String origin=s;
        String reverse=new StringBuilder(s).reverse().toString();
        int len=origin.length();
        int[] dp=new int[len];
        int maxLen=0;
        int end=0;
        for (int i = 0; i < len; i++) {
            for (int j = len-1 ; j >= 0; j--) {
                if(origin.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0){
                        dp[j]=1;
                    }else{
                        dp[j]=dp[j-1]+1;
                    }
                }
                if(dp[j]>maxLen){
                    int before=len-1-j;
                    if(before+dp[j]-1==i){
                        maxLen=dp[j];
                        end=i;
                    }
                }
            }
        }
        return s.substring(end-maxLen+1,end+1);
    }

    @Test
    public void test1(){
        System.out.println(longestPalindrome(("abccbadsw")));
    }
}
