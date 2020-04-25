package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/25
 */
public class Question77 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1,new LinkedList<Integer>(),n,k);
        return res;
    }

    private void backtrack(int first, LinkedList<Integer> list,int n,int k) {
        if(list.size()==k){
            res.add(new LinkedList<>(list));
        }
        for(int i=first;i<n+1;i++){
            list.add(i);
            backtrack(i+1,list,n,k);
            list.removeLast();
        }
    }


    @Test
    public void test1(){
        List<List<Integer>> lists = combine(4, 2);
        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
