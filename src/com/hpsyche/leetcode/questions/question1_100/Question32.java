package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/17
 */
public class Question32 {
    public int longestValidParentheses(String s) {
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+2;j<=s.length();j+=2){
                if(helper(s.substring(i,j))){
                    maxLen=Math.max(maxLen,j-i);
                }
            }
        }
        return maxLen;
    }

    private boolean helper(String substring) {
        int curr=0;
        int leftNum=0;
        while (curr<substring.length()) {
            if (substring.charAt(curr++) == '(') {
                leftNum++;
            } else {
                leftNum--;
                if (leftNum < 0) {
                    return false;
                }
            }
        }
        return leftNum==0;
    }

    public int longestValidParentheses2(String s) {
        int maxLen=0;
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else{
                    if(i-1>=dp[i-1]&&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                    }
                }
                maxLen=Math.max(maxLen,dp[i]);
            }
        }
        return maxLen;
    }

    public int longestValidParentheses3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    @Test
    public void test1(){
        System.out.println(longestValidParentheses3("())"));
        longestValidParentheses3(")()(()))");
        System.out.println(longestValidParentheses3(")()(()))"));
        System.out.println(longestValidParentheses3(")()())()()("));
        System.out.println(longestValidParentheses3("(()"));
    }
}
