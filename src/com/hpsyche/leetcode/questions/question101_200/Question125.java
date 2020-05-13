package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/13
 */
public class Question125 {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        s = s.toLowerCase();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if ((lc >= '0' && lc <= '9') || (lc >= 'a' && lc <= 'z')) {
                if ((rc >= '0' && rc <= '9') || (rc >= 'a' && rc <= 'z')) {
                    if (lc != rc) {
                        return false;
                    } else {
                        left++;
                        right--;
                    }
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
