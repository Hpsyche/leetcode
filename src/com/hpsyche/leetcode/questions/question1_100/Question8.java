package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/3
 */
public class Question8 {
    public int myAtoi(String str) {
        if(str.isEmpty()){
            return 0;
        }
        int i=0;
        boolean negative=false;
        while(i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if(i==str.length()){
            return 0;
        }
        if(str.charAt(i)=='-'){
            i++;
            negative=true;
        }else if(str.charAt(i)=='+'){
            i++;
        }
        long res=0;
        for(;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                res=res*10+(str.charAt(i)-'0');
                if(res> Integer.MAX_VALUE) {
                    if (negative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            }else{
                break;
            }
        }
        return negative?(int)-res:(int)res;
    }

    @Test
    public void test1(){
//
        System.out.println(myAtoi(""));
//        System.out.println(-91283472332<Integer.MIN_VALUE);
    }
}
