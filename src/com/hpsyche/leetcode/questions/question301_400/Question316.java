package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/26
 */
public class Question316 {
    public String removeDuplicateLetters(String s) {
        int[] map=new int[26];
        char[] chars = s.toCharArray();
        for(char c:chars){
            map[c-'a']++;
        }
        Stack<Character> stack=new Stack<>();
        for(char c:chars){
            if(!stack.contains(c)){
                while (!stack.isEmpty()&&stack.peek()>c&&map[stack.peek()-'a']>0){
                    stack.pop();
                }
                stack.push(c);
            }
            map[c-'a']--;
        }
        StringBuilder sb=new StringBuilder("");
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    @Test
    public void test1(){
        String bcabc = removeDuplicateLetters("cbacdcbc");
        System.out.println(bcabc);
    }
}
