package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/3
 */
public class Question5 {
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        String reverse=new StringBuilder(s).reverse().toString();
        int length=s.length();
        int maxLen=0;
        int maxEnd=0;
        int[] dp=new int[length];
        for(int i=0;i<length;i++){
            for(int j=length-1;j>=0;j--){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0) {
                        dp[j] = 1;
                    }else{
                        dp[j]=dp[j-1]+1;
                    }
                }else{
                    dp[j]=0;
                }
                if(dp[j]>maxLen){
                    int before=length-1-j;
                    if(before+dp[j]-1==i){
                        maxLen=dp[j];
                        maxEnd=i;
                    }
                }
            }
        }
        return s.substring(maxEnd-maxLen+1,maxEnd+1);
    }



    public String getLongSubString(String str1,String str2){
        int m=str1.length();
        int n=str2.length();
        int[] dp=new int[n];
        int maxLength=0;
        int maxI=0;
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j>=0; j--) {
                if(str1.charAt(i)==str2.charAt(j)){
                    if(j==0){
                        dp[j]=1;
                    }else{
                        dp[j]=dp[j-1]+1;
                    }
                    if(dp[j]>maxLength){
                        maxLength=dp[j];
                        maxI=i;
                    }
                }else{
                    dp[j]=0;
                }
            }
        }
        return str1.substring(maxI-maxLength,maxI);
    }

    public String getLongSubSuccession(String str1,String str2){
        int m=str1.length();
        int n=str2.length();
        int[][] dp=new int[m+1][n+1];
        int maxLength=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxLength=Math.max(maxLength,dp[i][j]);
            }
        }
        int currI=m;
        int currJ=n;
        Stack<Character> stack=new Stack<>();
        while (currI>0&&currJ>0){
            if(dp[currI][currJ]==dp[currI-1][currJ]){
                currI--;
            }else if(dp[currI][currJ]==dp[currI][currJ-1]){
                currJ--;
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


    public String longestPalindrome2(String s) {
        if(s==null||s.length()<1){
            return "";
        }
        int start=0;
        int end=0;
        for (int i = 0; i < s.length(); i++) {
            int len1=helper(s,i,i);
            int len2=helper(s,i,i+1);
            int len=Math.min(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int helper(String s, int begin, int end) {
        int l=begin;
        int r=end;
        while (l>=0&&r<=s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }


    @Test
    public void test1(){
        System.out.println(getLongSubSuccession("abrwftwwd","abftwwd"));
    }
}
