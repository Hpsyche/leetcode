package com.hpsyche.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/1
 */
public class Question20 {
    public boolean isValid(String s) {
        if(s.equals("")){
            return true;
        }
        int len=s.length();
        if(len<2){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        char[] array = s.toCharArray();
        for(char c:array){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else if(map.get(stack.peek())==null){
                return false;
            }
            else if(map.get(stack.peek())!=c){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test1(){
        System.out.println(isValid("([]){}"));
    }
}
