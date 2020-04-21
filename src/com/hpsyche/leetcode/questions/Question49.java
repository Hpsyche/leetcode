package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/4/21
 */
public class Question49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new LinkedList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(String.valueOf(chars))){
                res.get(map.get(String.valueOf(chars))).add(str);
            }else{
                map.put(String.valueOf(chars),res.size());
                LinkedList<String> tempList=new LinkedList<>();
                tempList.add(str);
                res.add(tempList);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> list:lists){
            for(String temp:list){
                System.out.print(temp+" ");
            }
            System.out.println();
        }
    }
}
