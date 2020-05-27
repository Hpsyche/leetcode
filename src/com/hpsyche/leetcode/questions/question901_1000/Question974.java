package com.hpsyche.leetcode.questions.question901_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/27
 */
public class Question974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int result=0;
        for(int a:A){
            sum+=a;
            int mod=(sum%K+K)%K;
            int preCount = map.getOrDefault(mod, 0);
            result+=preCount;
            map.put(mod,preCount+1);
        }
        return result;
    }
}
