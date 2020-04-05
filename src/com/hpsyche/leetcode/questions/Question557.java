package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/30
 */
public class Question557 {
    public String reverseWords(String s) {
        StringBuilder res=new StringBuilder("");
        String[] words = s.split(" ");
        for(String word:words){
            StringBuilder temp=new StringBuilder("");
            for(int i=word.length()-1;i>=0;i--){
                temp.append(word.charAt(i));
            }
            res.append(temp).append(" ");
        }
        return res.toString().trim();
    }

    @Test
    public void test1(){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
