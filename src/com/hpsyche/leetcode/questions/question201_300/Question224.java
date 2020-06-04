package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/4
 */
public class Question224 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> sign=new Stack<>();
        Stack<Integer> num=new Stack<>();
        int temp=-1;
        for(char c:chars){
            if(' ' == c){
                continue;
            }
            if(c>='0'&&c<='9'){
                if(temp==-1){
                    temp=c-'0';
                }else{
                    temp=temp*10+c-'0';
                }
            }else{
                if(temp!=-1){
                    num.push(temp);
                    temp=-1;
                }
                if(c=='+' || c=='-' ){
                    while (!sign.isEmpty()){
                        if(sign.peek()=='('){
                            break;
                        }
                        int num1=num.pop();
                        int num2=num.pop();
                        if (sign.pop() == '+') {
                            num.push(num1 + num2);
                        } else {
                            num.push(num2 - num1);
                        }
                    }
                    sign.push(c);
                }else{
                    if(c=='('){
                        sign.push(c);
                    }
                    if (c == ')') {
                        while (sign.peek()!='('){
                            int num1=num.pop();
                            int num2=num.pop();
                            if (sign.pop() == '+') {
                                num.push(num1 + num2);
                            } else {
                                num.push(num2 - num1);
                            }
                        }
                        sign.pop();
                    }
                }
            }
        }
        if(temp!=-1){
            num.push(temp);
        }
        //将栈中的其他元素继续运算
        while (!sign.isEmpty()) {
            int num1 = num.pop();
            int num2 = num.pop();
            if (sign.pop() == '+') {
                num.push(num1 + num2);
            } else {
                num.push(num2 - num1);
            }
        }
        return num.pop();
    }

    @Test
    public void test1(){
//        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
//        calculate(" 2-1+3");
        System.out.println(calculate(" 2-1+3"));

    }
}
