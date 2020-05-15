package com.hpsyche.leetcode.questions.question501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/15
 */
public class Question560_2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int res=0;
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                res+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
