package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/4
 */
public class Question224_2 {
    public int calculate(String s) {
        if(s==null){
            return 0;
        }
        int sign=1;
        Stack<Integer> stack=new Stack<>();
        stack.push(sign);
        int num=0;
        int result=0;
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c=='+'||c=='-'){
                result+=sign*num;
                num=0;
                System.out.println(stack.peek());
                sign=stack.peek()*(c=='+'?1:-1);
            }else if(c=='('){
                stack.push(sign);
            }else if(c==')'){
                stack.pop();
            }
        }
        result+=sign*num;
        return result;
    }

    @Test
    public void test1(){
//        int i=calculate("(1+(4+5+2)-3)+(6+8)");
        int i=calculate("2-(5-6)");
        System.out.println(i);
    }
}
