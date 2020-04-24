package com.hpsyche.leetcode.questions.question901_1000;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/31
 */
public class Question941 {
    public boolean validMountainArray(int[] A) {
        int len=A.length;
        if(len<3){
            return false;
        }
        int curr=1;
        boolean lFlag=false;
        boolean rFlag=false;
        while (curr<len){
            if(A[curr]>A[curr-1]){
                curr++;
                lFlag=true;
            }else{
                break;
            }
        }
        while (curr<len){
            if(A[curr]<A[curr-1]){
                curr++;
                rFlag=true;
            }else {
                break;
            }
        }
        return curr==len&&lFlag&&rFlag;
    }

    @Test
    public void test1(){
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
    }
}
