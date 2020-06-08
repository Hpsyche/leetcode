package com.hpsyche.leetcode.questions.question101_200;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/6/7
 */
public class Question126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        List<List<String>> res=new ArrayList<>();
        if(wordSet.size()==0||!wordSet.contains(endWord)){
            return res;
        }
        //广度优先遍历得到邻接矩阵
        Map<String,Set<String>> successors=new HashMap<>();
        boolean found=bfs(beginWord,endWord,wordSet,successors);
        if(!found){
            return res;
        }
        //基于successors，使用回溯算法得到所有最短路径列表
        Deque<String> path=new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord,endWord,successors,path,res);
        return res;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> successors, Deque<String> path, List<List<String>> res) {
        if(beginWord.equals(endWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        if(!successors.containsKey(beginWord)){
            return;
        }
        Set<String> successorWords=successors.get(beginWord);
        for(String nextWord:successorWords){
            path.addLast(nextWord);
            dfs(nextWord,endWord,successors,path,res);
            path.removeLast();
        }
    }

    private boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        //记录访问过的单词
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        boolean found=false;
        int wordLen=beginWord.length();
        //当前层节点全部遍历完成后，再添加到visited集合中
        Set<String> currLevelVisited=new HashSet<>();
        while (!queue.isEmpty()){
            int currSize=queue.size();
            for (int i = 0; i < currSize; i++) {
                String currWord=queue.poll();
                char[] chars = currWord.toCharArray();
                for(int j=0;j<wordLen;j++){
                    char originChar=chars[j];
                    for(char k='a';k<='z';k++){
                        if(chars[j]==k){
                            continue;
                        }
                        chars[j]=k;
                        String nextWord=new String(chars);
                        if (wordSet.contains(nextWord)) {
                            if(!visited.contains(nextWord)){
                                if(nextWord.equals(endWord)){
                                    found=true;
                                }
                                currLevelVisited.add(nextWord);
                                queue.offer(nextWord);
                                successors.computeIfAbsent(currWord,a->new HashSet<>());
                                successors.get(currWord).add(nextWord);
                            }
                        }
                    }
                    chars[j]=originChar;
                }
            }
            if(found){
                break;
            }
            visited.addAll(currLevelVisited);
            currLevelVisited.clear();
        }
        return found;
    }
}
