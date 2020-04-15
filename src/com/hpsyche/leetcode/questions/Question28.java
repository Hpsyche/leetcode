package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/4/15
 */
public class Question28 {
    public int strStr(String haystack, String needle) {
        int i=0,j=0;
        while (i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        return j==needle.length()?i-j:-1;
    }
}
