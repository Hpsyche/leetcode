package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hpsyche
 * Create on 2020/6/1
 */
public class Question208 {
    private TrieNode root;

    class TrieNode{
        boolean isEnd;
        TrieNode[] next;
        public TrieNode(){
            isEnd=false;
            next=new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public Question208() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.next[c-'a']==null){
                curr.next[c-'a']=new TrieNode();
            }
            curr=curr.next[c-'a'];
        }
        curr.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            curr=curr.next[c-'a'];
            if(curr==null){
                return false;
            }
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            curr=curr.next[c-'a'];
            if(curr==null){
                return false;
            }
        }
        return true;
    }
}
