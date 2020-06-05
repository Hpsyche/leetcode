package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/5
 */
public class Question227 {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        s=s.trim();
        char[] chars = s.toCharArray();
        char sign='+';
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=chars[i];
            if(' '==c){
                continue;
            }
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if(!Character.isDigit(c)||i==(s.length()-1)){
                int prev;
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        prev=stack.pop();
                        stack.push(prev*num);
                        break;
                    case '/':
                        prev=stack.pop();
                        stack.push(prev/num);
                        break;
                }
                sign=c;
                num=0;
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(calculate("-3"));
    }
}
