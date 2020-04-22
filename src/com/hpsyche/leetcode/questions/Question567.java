package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/4/22
 */
public class Question567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need=new HashMap<>();
        char[] chars = s1.toCharArray();
        for(char c:chars){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        Map<Character,Integer> window=new HashMap<>();
        int validNum=0;
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    validNum++;
                }
            }
            if ((right-left)==s1.length()){
                if(validNum==need.size()){
                    return true;
                }
                char d=s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        validNum--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return false;
    }

    @Test
    public void test1(){
        boolean b = checkInclusion("ab", "eidbaooo");
//        boolean b = checkInclusion("abcdxabcde","abcdeabcdx");
        System.out.println(b);
    }
}
