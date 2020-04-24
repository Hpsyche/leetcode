package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/4/22
 */
public class Question76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need=new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window=new HashMap<>();
        int left=0;
        int right=0;
        int validNum=0;
        int start=0;
        int minLen=Integer.MAX_VALUE;
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    validNum++;
                }
            }
            //左侧判断是否需要收缩
            while (validNum==need.size()){
                if(right-left<minLen){
                    start=left;
//                    System.out.println(right);
//                    System.out.println(left);
                    minLen=right-left;
                }
                char d=s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        validNum--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
//        System.out.println(start);
//        System.out.println(minLen);
//        return minLen==Integer.MAX_VALUE?"":((start+minLen)==s.length()?s.substring(start):s.substring(start,minLen));
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }


    @Test
    public void test1(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
//        System.out.println(minWindow("abc","b"));
    }
}
