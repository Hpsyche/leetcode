package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/9
 */
public class Question9 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int num=0;
        int curr=x;
        while (curr!=0){
            num=num*10+curr%10;
            curr/=10;
        }
        return num==x;
    }

    @Test
    public void test1(){
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
    }
}
