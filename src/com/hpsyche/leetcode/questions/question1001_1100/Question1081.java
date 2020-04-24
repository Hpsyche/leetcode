package com.hpsyche.leetcode.questions.question1001_1100;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/3/14
 */
public class Question1081 {
        public String smallestSubsequence(String text){
            Stack<Character> stack=new Stack<>();
            int len=text.length();
            for(int i=0;i<len;i++){
                char temp=text.charAt(i);
                if(stack.contains(temp)){
                    continue;
                }
                while(!stack.isEmpty()&&temp<stack.peek()&&text.lastIndexOf(stack.peek())>i){
                    stack.pop();
                }
                stack.push(temp);
            }
            StringBuilder sb=new StringBuilder("");
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
}
