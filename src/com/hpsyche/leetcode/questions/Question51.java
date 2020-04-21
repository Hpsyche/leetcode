package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/21
 */
public class Question51 {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res=new LinkedList<>();
        char[][] board=new char[n][n];
        for(char[] chars:board){
            Arrays.fill(chars,'.');
        }
        backtrack(board,0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if(row==board.length){
            res.add(charToStringList(board));
            return;
        }
        int n=board[row].length;
        for(int col=0;col<n;col++){
            if(!valid(board,row,col)){
                continue;
            }
            board[row][col]='Q';
            backtrack(board,row+1);
            board[row][col]='.';
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        //check col
        for(char[] chars:board){
            if(chars[col]=='Q'){
                return false;
            }
        }
        //check upRight
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //check upLeft
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> charToStringList(char[][] board) {
        List<String> res=new LinkedList<>();
        for(char[] chars:board){
            res.add(String.valueOf(chars));
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(solveNQueens(4));
    }
}
