package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/26
 */
public class Question79 {
    int[][] dire=new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
//        if(word.length()==1&&board[0][0]==word.charAt(0)){
//            return true;
//        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = helper(board, word, i, j, 0, visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int x, int y, int currIndex,boolean[][] visited) {
        if(currIndex>=word.length()){
            return true;
        }
        if(board[x][y]!=word.charAt(currIndex)){
            return false;
        }
        if(currIndex==word.length()-1){
            return true;
        }
        visited[x][y]=true;
        for(int i=0;i<dire.length;i++){
            int currX=x+dire[i][0];
            int currY=y+dire[i][1];
            if(currX<0||currX>=board.length||currY<0||currY>=board[0].length||visited[currX][currY]){
                continue;
            }
            if(helper(board,word,currX,currY,currIndex+1,visited)){
                return true;
            }
        }
        visited[x][y]=false;
        return false;
    }


    @Test
    public void test1(){
        char[][] board=new char[][]{
                {'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}
        };
//        char[][] board=new char[][]{
//                {'c','a','a'},{'a','a','a'},{'b','c','d'}
//        };
//        char[][] board=new char[][]{
//                {'a','a'}
//        };
//        boolean abcced = exist(board, "abcced");
//        boolean abcced = exist(board, "aab");
        boolean abcced = exist(board, "aa");
        System.out.println(abcced);
    }
}
