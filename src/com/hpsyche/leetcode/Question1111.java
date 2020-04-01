package com.hpsyche.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/1
 */
public class Question1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        int d=0;
        char[] chars = seq.toCharArray();
        int curr=0;
        for(char c:chars){
            if(c=='('){
                d+=1;
                res[curr++]=d%2;
            }
            else if(c==')'){
                res[curr++]=d%2;
                d-=1;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] max=maxDepthAfterSplit("()(())()");
        for(int temp:max){
            System.out.println(temp);
        }
    }
}
