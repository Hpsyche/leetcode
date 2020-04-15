package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/4/15
 */
public class Question30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if(words.length==0){
            return res;
        }
        Map<String,Integer> hash=new HashMap<>();
        int len=words[0].length();
        int totalLen=len*words.length;
        for(String word:words){
            hash.put(word,hash.getOrDefault(word,0)+1);
        }
        for(int i=0;i+totalLen-1<s.length();i++){
            String temp=s.substring(i,i+totalLen);
            Map<String,Integer> tempMap=new HashMap<>();
            for(int j=0;j<totalLen;j+=len){
                String w=temp.substring(j,j+len);
                tempMap.put(w,tempMap.getOrDefault(w,0)+1);
            }
            if(tempMap.equals(hash)){
                res.add(i);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        List<Integer> barfoothefoobarman = findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        for(int i:barfoothefoobarman){
            System.out.println(i);
        }
    }
}
