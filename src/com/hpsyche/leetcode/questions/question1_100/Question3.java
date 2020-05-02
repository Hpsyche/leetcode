package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/5/2
 */
public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int start=0;
        int end=-1;
        int maxLen=0;
        Map<Character,Integer> map=new HashMap<>();
        while (end<len-1){
            end++;
            if(map.containsKey(s.charAt(end))&&map.get(s.charAt(end))>0) {
                while (map.get(s.charAt(end)) > 0) {
                    char c = s.charAt(start++);
                    map.put(c, map.get(c) - 1);
                }
            }
            map.put(s.charAt(end),1);
            maxLen= Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        Map<Character,Integer> map=new HashMap<>();
        int max=0;
        int left=0;
        for (int i=0;i<len;i++){
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }

    @Test
    public void test1(){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
