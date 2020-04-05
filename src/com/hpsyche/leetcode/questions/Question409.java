package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/19
 */
public class Question409 {
    public int longestPalindrome(String s) {
        int[] dict=new int[52];
        int count=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            int positions=s.charAt(i);
            if(positions>90){
                dict[positions-97]++;
            }else{
                dict[positions-39]++;
            }
        }
        for(int i:dict){
            if(i>1){
                count+=(i/2*2);
            }
        }
        return count<s.length()?count+1:count;
    }


    @Test
    public void test1(){
        System.out.println(longestPalindrome("abccccdd"));
    }
}
