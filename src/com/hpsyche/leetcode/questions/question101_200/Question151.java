package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/10
 */
public class Question151 {
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        StringBuilder sb=new StringBuilder("");
        for(String word:words){
            int len=word.length();
            while (len>0){
                sb.append(word.charAt(--len));
            }
            sb.append(" ");
        }
        return sb.reverse().toString().trim();
    }

    @Test
    public void test1(){
        System.out.println(reverseWords("a good   example"));
    }
}
