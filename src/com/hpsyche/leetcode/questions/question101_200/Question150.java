package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/25
 */
public class Question150 {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0){
            return 0;
        }
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if(isFuHao(token)){
                int b = stack.pop();
                int a = stack.pop();
                switch (token){
                    case "+":stack.push(a+b);break;
                    case "-":stack.push(a-b);break;
                    case "*":stack.push(a*b);break;
                    case "/":stack.push(a/b);break;
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isFuHao(String token) {
        return token.equals("+") ||token.equals("-")||token.equals("*")||token.equals("/");
    }

    @Test
    public void test1(){
        String[] tokens=new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
