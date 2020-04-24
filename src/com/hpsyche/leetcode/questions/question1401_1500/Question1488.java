package com.hpsyche.leetcode.questions.question1401_1500;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/4
 */
public class Question1488 {
    public int calculate(String s) {
        Stack<Integer> num=new Stack<>();
        char[] chars=s.replaceAll(" ","").toCharArray();
        //追踪前一个字符串
        char pre=' ';
        int n=chars.length;
        int curr=0;
        StringBuilder sb=new StringBuilder("");
        while (curr<n&&Character.isDigit(chars[curr])){
            sb.append(chars[curr++]);
        }
        int currNum=Integer.parseInt(sb.toString());
        num.push(currNum);
        for(;curr<n;curr++){
            char fuhao=chars[curr++];
            StringBuilder nextSb=new StringBuilder("");
            while (curr<n&&Character.isDigit(chars[curr])){
                nextSb.append(chars[curr++]);
            }
            int nextNum=Integer.parseInt(nextSb.toString());
            if(fuhao=='*'||fuhao=='/'){
                if(fuhao=='*') {
                    num.push(num.pop() * nextNum);
                }else{
                    num.push(num.pop() / nextNum);
                }
            }
            else if(fuhao=='+'){
                num.push(nextNum);
            }else{
                num.push(-nextNum);
            }
            curr--;
        }
        int res=0;
        while (!num.isEmpty()){
            res+=num.pop();
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(calculate(" 3+2 * 2"));
    }
}
