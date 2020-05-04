package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/4
 */
public class Question5_3 {
    public String longestSuccession(String str1,String str2) {
        int len1=str1.length();
        int len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];
        int maxLength=0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxLength=Math.max(maxLength,dp[i][j]);
            }
        }
        int currI=len1;
        int currJ=len2;
        Stack<Character> stack=new Stack<>();
        while (currI>0&&currJ>0){
            if(dp[currI][currJ]==dp[currI-1][currJ]){
                currI--;
            }else if(dp[currI][currJ]==dp[currI][currJ-1]){
                currI--;
            }else if(dp[currI][currJ]>dp[currI-1][currJ-1]){
                currI--;
                currJ--;
                stack.push(str1.charAt(currI));
            }
        }
        StringBuilder sb=new StringBuilder("");
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    @Test
    public void test1(){
        System.out.println(longestSuccession("abrwftwwd","abftwwd"));
    }

}