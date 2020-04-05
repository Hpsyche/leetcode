package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/3
 */
public class Question1304 {
    public int[] sumZero(int n) {
        int[] res=new int[n];
        int curr=1;
        if(n%2==0){
            for(int i=0;i<n;){
                res[i++]=curr;
                res[i++]=-1*curr;
                curr++;
            }
        }else{
            res[0]=0;
            for(int i=1;i<n;){
                res[i++]=curr;
                res[i++]=-1*curr;
                curr++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] ints = sumZero(1);
        for(int i:ints){
            System.out.println(i);
        }
    }
}
