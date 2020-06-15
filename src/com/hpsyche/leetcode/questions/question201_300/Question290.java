package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/6/15
 */
public class Question290 {
    public boolean wordPattern(String pattern, String str) {
        String[] position=new String[26];
        Set<String> words=new HashSet<>();
        String[] strs=str.split(" ");
        if(pattern.length()!=strs.length){
            return false;
        }
        for(int i=0;i<strs.length;i++){
            String curr=strs[i];
            String posStr=position[pattern.charAt(i)-'a'];
            if(posStr!=null){
                if(!posStr.equals(curr)){
                    return false;
                }
            }else{
                if(words.contains(curr)){
                    return false;
                }
                words.add(curr);
                position[pattern.charAt(i)-'a']=curr;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        String pattern="abba";
        String str="dog cat ca2t dog";
        System.out.println(wordPattern(pattern,str));
    }
}
