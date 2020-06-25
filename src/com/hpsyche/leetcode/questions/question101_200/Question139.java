package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/5/20
 */
public class Question139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        int len=s.length();
        boolean[] dp=new boolean[len];
        for(int r=0;r<len;r++){
            if(set.contains(s.substring(0,r+1))){
                dp[r]=true;
                continue;
            }
            for(int l=0;l<r;l++){
                if(dp[l]&&set.contains(s.substring(l+1,r+1))){
                    dp[r]=true;
                    break;
                }
            }
        }
        return dp[len-1];
    }


    @Test
    public void test1(){
        List<String> list=new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("og");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wordBreak("catsandog",list));
    }
}
