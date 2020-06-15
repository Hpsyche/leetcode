package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/8
 */
public class Question14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {return "";}
            }
        }
        return prefix;
    }

    @Test
    public void test1(){
        String[] str=new String[]{
                "flower","flow","flight"
        };
        longestCommonPrefix(str);
        System.out.println(longestCommonPrefix(str));
//        System.out.println("flight".indexOf("flow"));
    }
}
