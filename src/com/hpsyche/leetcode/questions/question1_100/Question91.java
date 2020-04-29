package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/29
 */
public class Question91 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=chars[0]=='0'?0:1;
        if(s.length()<=1){
            return dp[1];
        }
        for (int i = 2; i <= s.length(); i++) {
            int n=(chars[i-2]-'0')*10+(chars[i-1]-'0');
            if(chars[i-1]=='0'&&chars[i-2]=='0'){
                return 0;
            }else if(chars[i-2]=='0'){
                dp[i]=dp[i-1];
            }else if(chars[i-1]=='0'){
                if(n>26){
                    return 0;
                }
                dp[i]=dp[i-2];
            }else if(n>26){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test(){
//        int i = numDecodings("0");
//        int i = numDecodings("0");
//        int i = numDecodings("2202");
        int i = numDecodings("1212");
        System.out.println(i);
    }
}
