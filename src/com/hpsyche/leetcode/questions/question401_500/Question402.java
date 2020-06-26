package com.hpsyche.leetcode.questions.question401_500;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/26
 */
public class Question402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        char[] chars=num.toCharArray();
        for(char c:chars){
            while (k>0&&!stack.isEmpty()&&c<stack.peek()){
                stack.pop();
                k-=1;
            }
            stack.push(c);
        }
        StringBuilder sb=new StringBuilder("");
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.delete(0,k);
        for(int i=sb.length()-1;i>0;i--){
            if(sb.charAt(i)=='0'){
                sb.deleteCharAt(i);
            }else{
                break;
            }
        }
        if("".equals(sb.toString())){
            return "0";
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
//        String s = removeKdigits("1432219", 3);
        String s = removeKdigits("10200", 1);
//        String s = removeKdigits("10", 2);
//        String s = removeKdigits("9", 1);
//        String s = removeKdigits("112", 1);
        System.out.println(s);
    }
}
