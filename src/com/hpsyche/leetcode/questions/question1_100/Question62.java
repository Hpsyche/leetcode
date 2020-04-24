package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/3/30
 */
public class Question62 {
    public int lastRemaining(int n, int m) {
        List<Integer> list=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index=0;
        while (n>1){
            index=(index+m-1)%m;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    @Test
    public void fun1(){
        lastRemaining(10,17);
        System.out.println();
    }
}
