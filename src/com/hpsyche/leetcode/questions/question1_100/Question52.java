package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/4/21
 */
public class Question52 {
    int count=0;
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] chars:board){
            Arrays.fill(chars,'.');
        }
        backtrack(board,0);
        return count;
    }

    private void backtrack(char[][] board,int curr) {
        int row=board.length;
        if(curr==row){
            count++;
            return;
        }
        for(int col=0;col<row;col++){
            if(!isValid(board,curr,col)){
                continue;
            }
            board[curr][col]='Q';
            backtrack(board,curr+1);
            board[curr][col]='.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for(char[] chars:board){
            if(chars[col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test1(){
        System.out.println(totalNQueens(4));
    }
}
