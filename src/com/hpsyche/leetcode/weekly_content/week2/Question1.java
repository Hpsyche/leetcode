package com.hpsyche.leetcode.weekly_content.week2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/12
 */
public class Question1 {
    public List<String> stringMatching(String[] words) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j) {
                    if (words[i].contains(words[j])) {
                        if(!res.contains(words[j])) {
                            res.add(words[j]);
                        }
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        List<String> strings = stringMatching(new String[]{"blue","green","bu"});
        for(String s:strings){
            System.out.println(s);
        }
    }
}
