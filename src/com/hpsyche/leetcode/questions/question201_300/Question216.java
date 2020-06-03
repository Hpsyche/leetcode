package com.hpsyche.leetcode.questions.question201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/3
 */
public class Question216 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res=new ArrayList<>();
        backtrace(1,n,k,new ArrayList<Integer>());
        return res;
    }

    private void backtrace(int curr, int n, int k,ArrayList<Integer> list) {
        if(n==0&&k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(n<=0||k<=0){
            return;
        }
        for (int i = curr; i <= 9; i++) {
            list.add(i);
            backtrace(i+1,n-i,k-1,list);
            list.remove(list.size()-1);
        }
    }
}
