package com.hpsyche.leetcode.questions.question901_1000;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/3/19
 */
public class Question989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
       int len=A.length;
       int lastSum=K;
       LinkedList<Integer> resList=new LinkedList<>();
       int i=len-1;
       while(i>=0||lastSum>0){
           if(i>=0){
               lastSum+=A[i];
           }
           resList.addFirst(lastSum%10);
           lastSum/=10;
           i--;
       }
       return resList;
    }

    @Test
    public void test1(){
        int[] a=new int[]{7};
        List<Integer> list = addToArrayForm(a, 993);
        for(int temp:list){
            System.out.println(temp);
        }
    }
}
