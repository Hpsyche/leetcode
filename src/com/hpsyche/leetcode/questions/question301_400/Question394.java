package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/28
 */
public class Question394 {
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder("");
        Stack<Character> stack=new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c==']'){
                StringBuilder temp=new StringBuilder("");
                while (true){
                    char pop = stack.pop();
                    if(pop=='['){
                        break;
                    }
                    temp.append(pop);
                }
                int count=0;
                int currMulti=1;
                while (!stack.isEmpty()&&Character.isDigit(stack.peek())){
                    count+=(stack.pop()-'0')*currMulti;
                    currMulti*=10;
                }
                temp.reverse();
                String curr=temp.toString();
                for (int i = 1; i < count; i++) {
                    temp.append(curr);
                }
                for (char tC:temp.toString().toCharArray()){
                    stack.push(tC);
                }
            }else{
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }


    @Test
    public void test1(){
        String s = decodeString("100[leetcode]");
//        3[a2[c]]
        System.out.println(s);
    }
}
