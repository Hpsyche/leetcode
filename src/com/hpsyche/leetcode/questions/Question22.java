package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/9
 */
public class Question22 {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,n,"");
        return res;
    }

    private void helper(int left, int right,String str) {
        if(left==0&&right==0){
            res.add(str);
            return;
        }
        if(left>0){
            helper(left-1,right,str+"(");
        }
        if(right>left){
            helper(left,right-1,str+")");
        }
    }

    @Test
    public void test1(){
        List<String> strings = generateParenthesis(3);
        for(String str:strings){
            System.out.println(str);
        }
    }
}
