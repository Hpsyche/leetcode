package com.hpsyche.leetcode.questions.question201_300;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/1
 */
public class Question212 {
    private TrieNode root=new TrieNode();
    private List<String> res=new LinkedList<>();
    class TrieNode{
        String word;
        TrieNode[] children;

        public TrieNode() {
            word=null;
            children=new TrieNode[26];
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words){
            insert(word);
        }
        int m=board.length;
        int n=board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board,i,j,root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j,TrieNode curr) {
        if(i<0||i>=board.length||j<0||j>=board[0].length){
            return ;
        }
        if(board[i][j]=='*'){
            return;
        }
        if(curr.children[board[i][j]-'a']==null){
            return;
        }
        curr=curr.children[board[i][j]-'a'];
        if(curr.word!=null){
            res.add(curr.word);
            //避免重复加入
            curr.word=null;
        }
        char tmpChar=board[i][j];
        board[i][j]='*';
        dfs(board,i+1,j,curr);
        dfs(board,i-1,j,curr);
        dfs(board,i,j+1,curr);
        dfs(board,i,j-1,curr);
        board[i][j]=tmpChar;
    }

    private void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.word=word;
    }
}
