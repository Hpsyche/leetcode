package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/14
 */
public class Question130 {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return;
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int i=0;i<n;i++){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        board[i][j]='-';
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        for(int m=0;m<4;m++){
           dfs(board,i+dx[m],j+dy[m]);
        }
    }

    @Test
    public void test1(){
//        char[][] c=new char[][]{
//                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}
//        };
        char[][] c=new char[][]{
                {'O','O','O'},{'O','O','O'},{'O','O','O'}
        };
        solve(c);

        for(char[] cs:c){
            for(char k:cs){
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
}
