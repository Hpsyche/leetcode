package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/1
 */
public class Question211 {
    private TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            isEnd=false;
            children=new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public Question211() {
        root=new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word.length()==0){
            root.isEnd=true;
            return;
        }
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,root);
    }

    public boolean search(String word,TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for (int j = 0; j < 26; j++) {
                    if(curr.children[j]!=null){
                        if(search(word.substring(i+1),curr.children[j])){
                            return true;
                        }
                    }
                }
                return false;
            }
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return curr.isEnd;
    }

}
