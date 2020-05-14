package com.hpsyche.leetcode.questions.question101_200;

import javafx.util.Pair;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/5/14
 */
public class Question127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int len=beginWord.length();
        Map<String,List<String>> allDict=new HashMap<>();
        wordList.forEach(currWord->{
            for (int i = 0; i < len; i++) {
                String getWord=currWord.substring(0,i)+"*"+currWord.substring(i+1,len);
                List<String> currList=allDict.getOrDefault(getWord, new ArrayList<>());
                currList.add(currWord);
                allDict.put(getWord,currList);
            }
        });
        Queue<Pair<String,Integer>> queue=new LinkedList<>();
        Map<String,Boolean> visited=new HashMap<>();
        queue.add(new Pair<>(beginWord,1));
        visited.put(beginWord,true);
        while (!queue.isEmpty()){
            Pair<String, Integer> remove = queue.remove();
            String curr=remove.getKey();
            int level=remove.getValue();
            for (int i = 0; i < len; i++) {
                String getWord=curr.substring(0,i)+"*"+curr.substring(i+1,len);
                List<String> currList=allDict.getOrDefault(getWord,new ArrayList<>());
                for(String word:currList){
                    if(word.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.containsKey(word)){
                        queue.add(new Pair<>(word,level+1));
                        visited.put(word,true);
                    }
                }
            }
        }
        return 0;
    }
}
