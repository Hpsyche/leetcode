package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/18
 */
public class Question36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            if(!validHang(board, i)){
                return false;
            };
        }
        for(int i=0;i<9;i++) {
            if(!validLie(board, i)){
                return false;
            };
        }
        for(int i=0;i<=6;i+=3){
            for(int j=0;j<=6;j+=3){
                if(!validNice(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validNice(char[][] board, int m,int n) {
        boolean[] flag=new boolean[10];
        for(int i=m;i<(m+3);i++){
            for(int j=n;j<(n+3);j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                if(flag[board[i][j]-'0']){
                    return false;
                }
                flag[board[i][j]-'0']=true;
            }
        }
        return true;
    }

    private boolean validLie(char[][] board, int j) {
        boolean[] flag=new boolean[10];
        for(int i=0;i<9;i++){
            if(board[i][j]=='.'){
                continue;
            }
            if(flag[board[i][j]-'0']){
                return false;
            }
            flag[board[i][j]-'0']=true;
        }
        return true;
    }

    private boolean validHang(char[][] board, int i) {
        boolean[] flag=new boolean[10];
        for(int j=0;j<9;j++){
            if(board[i][j]=='.'){
               continue;
            }
            if(flag[board[i][j]-'0']){
                return false;
            }
            flag[board[i][j]-'0']=true;
        }
        return true;
    }


    @Test
    public void test1(){
        char[][] c=new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = isValidSudoku(c);
        System.out.println(validSudoku);
    }
}
