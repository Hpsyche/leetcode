package com.hpsyche.leetcode.weekly_content.week1;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author hpsyche
 * Create on 2020/4/5
 */
public class Question5377 {
    public int numSteps(String s) {
        int count=0;
        char[] chars = s.toCharArray();
        int curr=chars.length-1;
        while (curr>0){
            count++;
            if(chars[curr]=='0'){
                curr--;
            }else{
                while (curr>=0&&chars[curr]=='1'){
                    count++;
                    curr--;
                }
                if(curr>0){
                    chars[curr]='1';
                }
            }
        }
        return count;
    }
    @Test
    public void test1(){
        System.out.println(numSteps("11000"));
    }
}
