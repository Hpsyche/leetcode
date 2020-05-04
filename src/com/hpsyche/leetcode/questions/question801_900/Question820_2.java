package com.hpsyche.leetcode.questions.question801_900;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/5/4
 */
public class Question820_2 {
    public int minimumLengthEncoding(String[] words) {
        Trie trie=new Trie();
        int res=0;
        Arrays.sort(words,(s1,s2)->
            s2.length()-s1.length());
        for(String word:words){
            res+=trie.insert(word);
        }
        return res;
    }

    class Trie{
        TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        public int insert(String word){
            TrieNode curr=root;
            boolean isNew=false;
            for(int i=word.length()-1;i>=0;i--){
                int c=word.charAt(i)-'a';
                if(curr.children[c]==null){
                    isNew=true;
                    curr.children[c]=new TrieNode();
                }
                curr=curr.children[c];
            }
            return isNew?word.length()+1:0;
        }
    }

    class TrieNode{
        char val;
        TrieNode[] children=new TrieNode[26];
        public TrieNode(){};
    }
}
