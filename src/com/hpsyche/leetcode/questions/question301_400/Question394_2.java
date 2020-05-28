package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/28
 */
public class Question394_2 {
    public String decodeString(String s) {
        Stack<Integer> nums=new Stack<>();
        Stack<String> strs=new Stack<>();
        StringBuilder res=new StringBuilder("");
        char[] chars = s.toCharArray();
        int currNum=0;
        for(char c:chars){
            if(Character.isDigit(c)){
                currNum=currNum*10+c-'0';
            }else if(Character.isLetter(c)){
                res.append(c);
            }else if(c=='['){
                if(currNum>0){
                    nums.push(currNum);
                    strs.push(res.toString());
                    res=new StringBuilder();
                    currNum=0;
                }
            }else{
                StringBuilder temp=new StringBuilder().append(strs.pop());
                int count=nums.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res=temp;
            }
        }
        return res.toString();
    }

    @Test
    public void test1(){
        System.out.println(decodeString("100[leetcode]"));
    }
}
