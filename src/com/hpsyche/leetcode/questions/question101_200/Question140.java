package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Question140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：以 s[i] 结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];

        // 预处理
        Set<String> wordSet = new HashSet<>(wordDict);
        for(int r=0;r<len;r++){
            if(wordSet.contains(s.substring(0,r+1))){
                dp[r]=true;
                continue;
            }
            for(int l=0;l<r;l++){
                if(dp[l]&&wordSet.contains(s.substring(l+1,r+1))){
                    dp[r]=true;
                    break;
                }
            }
        }
        List<String> res=new LinkedList<>();
        if(dp[len-1]){
            LinkedList<String> queue=new LinkedList<>();
            dfs(s,len-1,wordSet,res,queue,dp);
        }
        return res;

    }

    private void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if(wordSet.contains(s.substring(0,end+1))){
            queue.addFirst(s.substring(0,end+1));
            StringBuilder sb=new StringBuilder("");
            for(String word:queue){
                sb.append(word).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            queue.removeFirst();
        }
        for(int i=0;i<end;i++){
            if(dp[i]){
                String temp=s.substring(i+1,end+1);
                if(wordSet.contains(temp)){
                    queue.addFirst(temp);
                    dfs(s,i,wordSet,res,queue,dp);
                    queue.removeFirst();
                }
            }
        }
    }

    @Test
    public void test1(){
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        List<String> res = wordBreak(s, wordDict);
        System.out.println(res);
    }

}