package com.hpsyche.leetcode.weekly_content.week194;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/6/21
 */
public class Question2 {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map=new HashMap<>();
        String[] res=new String[names.length];
        for (int i = 0; i < res.length; i++) {
            String name=names[i];
            if(map.containsKey(name)){
                res[i]=name+"("+map.get(name)+")";
                while (map.containsKey(res[i])){
                    map.put(name,map.getOrDefault(name,0)+1);
                    res[i]=name+"("+map.get(name)+")";
                }
            }else{
                res[i]=name;
            }
            map.put(res[i],map.getOrDefault(res[i],0)+1);
        }
        return res;
    }
}
