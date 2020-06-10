package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/10
 */
public class Question242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        for(char c:t.toCharArray()){
            if(count[c-'a']<=0){
                return false;
            }
            count[c-'a']--;
        }
        return true;
    }

    @Test
    public void test1(){
        System.out.println(isAnagram("anagram","nagaraa"));
    }
}
