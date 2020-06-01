package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/1
 */
public class Question214 {
    public String shortestPalindrome(String s) {
        String newStr=s+"#"+new StringBuilder(s).reverse();
        int max=getLastNext(newStr);
        return new StringBuilder(s.substring(max)).reverse()+s;
    }

    public int getLastNext(String s){
        char[] array = s.toCharArray();
        int len=s.length();
        int[] next=new int[len+1];
        next[0]=-1;
        next[1]=0;
        int curr=2;
        int cn=0;
        while (curr<=len){
            if(array[curr-1]==array[cn]){
                next[curr++]=++cn;
            }else if(cn>0){
                cn=next[cn];
            }else{
                next[curr++]=0;
            }
        }
        return next[len];
    }

    @Test
    public void test1(){
        System.out.println(shortestPalindrome("aacecaaa"));
//        System.out.println(getLastNext("aacecaaa#aaacecaa"));
    }
}
