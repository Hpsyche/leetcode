package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/8
 */
public class Question168 {
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder("");
        while(n>0){
            n--;
            sb.append((char) (n % 26  + 'A'));
            n/=26;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test1(){
        System.out.println(convertToTitle(29));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));
    }
}
