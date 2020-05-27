package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/27
 */
public class Question171 {
    public int titleToNumber(String s) {
        int len=s.length();
        int res=0;
        int multi=1;
        for(int i=len-1;i>=0;i--){
            res+=(s.charAt(i)-'A'+1)*multi;
            multi*=26;
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(titleToNumber("ZY"));
    }
}
