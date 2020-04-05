package com.hpsyche.leetcode.questions;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/4/3
 */
public class Question187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len-9;i++){
            String cur = s.substring(i, i+10);
            if(!map.containsKey(cur)) {
                map.put(cur, 1);
            }else if(map.get(cur) == 1) {
                res.add(cur);
                map.put(cur, 2);
            }else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        return res;
    }
}
