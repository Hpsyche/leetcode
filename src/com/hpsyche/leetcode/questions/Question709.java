package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/6
 */
public class Question709 {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='A'&&chars[i]<='Z'){
                chars[i]+=32;
            }
        }
        return String.valueOf(chars);
    }

    @Test
    public void test1(){
        System.out.println(toLowerCase("aAdhasoihBDHAOIdhasoi"));
    }
}
