package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/30
 */
public class Question58 {
    public int lengthOfLastWord(String s) {
        String regex="\\s+";
        String[] split = s.split(regex);
        if(split.length==0){
            return 0;
        }
        return split[split.length-1].length();
    }

    @Test
    public void test1(){
        System.out.println(lengthOfLastWord("hello world"));
    }
}
