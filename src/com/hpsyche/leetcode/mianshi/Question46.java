package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/9
 */
public class Question46 {
    public int translateNum(int num) {
        String input=String.valueOf(num);
        int len=input.length();
        if(len<2){
            return len;
        }
        int[] dp=new int[len];
        dp[0]=1;
        dp[1]=Integer.parseInt(input.charAt(0)+""+input.charAt(1))<26?2:1;
        for (int i = 2; i < len; i++) {
            dp[i]=dp[i-1];
            if(Integer.parseInt(input.charAt(i-1)+""+input.charAt(i))<26&&input.charAt(i-1)!='0'){
                dp[i]+=dp[i-2];
            }
        }
        return dp[len-1];
    }

    public int translateNum2(int num) {
        String input=String.valueOf(num);
        int len=input.length();
        if(len<2){
            return len;
        }
        int numA=1;
        int numB=Integer.parseInt(input.charAt(0)+""+input.charAt(1))<26?2:1;
        int curr=numB;
        for (int i = 2; i < len; i++) {
            curr=numB;
            if(Integer.parseInt(input.charAt(i-1)+""+input.charAt(i))<26&&input.charAt(i-1)!='0'){
                curr+=numA;
            }
            numA=numB;
            numB=curr;
        }
        return curr;
    }

    @Test
    public void test1(){
        System.out.println(translateNum2(25));
    }
}
