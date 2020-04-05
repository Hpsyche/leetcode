package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author hpsyche
 * Create on 2020/3/17
 */
public class Question1160 {
    public int countCharacters(String[] words, String chars) {
        int[] hash=new int[26];
        for(int i=0;i<chars.length();i++){
            hash[chars.charAt(i)-'a']++;
        }
        int count=0;
        for(String word:words){
            boolean flag=true;
            int[] tempHash = Arrays.copyOf(hash, 26);
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(tempHash[index]==0){
                    flag=false;
                    break;
                }else{
                    tempHash[index]--;
                }
            }
            if(flag){
                count+=word.length();
            }
        }
        return count;
    }

    @Test
    public void test1(){
        String[] words=new String[]{"hello","world","leetcode"};
        String chars="welldonehoneyr";
        System.out.println(countCharacters(words,chars));
    }
}
