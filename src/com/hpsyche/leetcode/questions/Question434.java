package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/8
 */
public class Question434 {
    public int countSegments(String s) {
        String[] arr = s.split(" ");
        int len = 0;
        for (String t : arr) {
            if (t.equals(" ") || t.isEmpty()){
                continue;
            }
            len++;
        }
        return len;
    }

    @Test
    public void test1(){
        System.out.println(countSegments("dsad sda    sl,s"));
    }
}
