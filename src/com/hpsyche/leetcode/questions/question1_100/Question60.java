package com.hpsyche.leetcode.questions.question1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/3/20
 */
public class Question60 {
    public String getPermutation(int n, int k) {
        int[] fact=new int[n];
        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        fact[0]=1;
        for(int i=1;i<n;++i){
            fact[i]=fact[i-1]*i;
            nums.add(i+1);
        }
        --k;
        StringBuilder sb=new StringBuilder("");
        for(int i=n-1;i>=0;--i){
            int idx=k/fact[i];
            k-=idx*fact[i];
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
}
