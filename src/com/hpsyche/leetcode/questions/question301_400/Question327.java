package com.hpsyche.leetcode.questions.question301_400;

import java.util.TreeMap;

/**
 * @author hpsyche
 * Create on 2020/7/1
 */
public class Question327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        //键：前缀和；值：前缀和的个数
        TreeMap<Long,Integer> map=new TreeMap<>();
        map.put(0L,1);
        int res=0;
        long sum=0L;
        for(int num:nums){
            sum+=num;
            for(int curr:map.subMap(sum-upper,true,sum-lower,true).values()){
                res+=curr;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
