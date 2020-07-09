package com.hpsyche.leetcode.mianshi;

import sun.text.normalizer.Trie;

/**
 * @author hpsyche
 * Create on 2020/7/9
 */
public class Question17_13_2 {
    class TrieTree{
        TrieTree[] children;
        boolean isWord;
        public TrieTree(){
            children=new TrieTree[26];
            isWord=false;
        }
    }
    TrieTree root;

    public int respace(String[] dictionary, String sentence) {
        root=new TrieTree();
        buildTrie(dictionary);
        int len=sentence.length();
        int[] dp=new int[len+1];
        for (int i = len-1; i >= 0; i--) {
            //初始化为最大值，即后面全不匹配
            dp[i]=len-i;
            TrieTree curr=root;
            for (int j = i; j < len; j++) {
                int c=sentence.charAt(j)-'a';
                if(curr.children[c]==null){
                    dp[i]=Math.min(dp[i],j-i+1+dp[j+1]);
                    break;
                }
                if(curr.children[c].isWord){
                    dp[i]=Math.min(dp[i],dp[j+1]);
                }else{
                    dp[i]=Math.min(dp[i],j-i+1+dp[j+1]);
                }
                curr=curr.children[c];
            }
        }
        return dp[0];
    }

    private void buildTrie(String[] dictionary) {
        for(String word:dictionary){
            TrieTree curr=root;
            for (int i = 0; i < word.length(); i++) {
                int num=word.charAt(i)-'a';
                if(curr.children[num]==null){
                    curr.children[num]=new TrieTree();
                }
                curr=curr.children[num];
            }
            curr.isWord=true;
        }
    }
}