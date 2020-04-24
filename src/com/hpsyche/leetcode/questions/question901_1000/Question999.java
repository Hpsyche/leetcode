package com.hpsyche.leetcode.questions.question901_1000;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/26
 */
public class Question999 {
    public int numRookCaptures(char[][] board) {
        int Ri=-1;
        int Rj=-1;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    Ri=i;
                    Rj=j;
                    break;
                }
            }
        }
        int count=0;
        if(Ri==-1){
            return 0;
        }
        //往上面找
        for(int i=Ri-1;i>=0;i--){
            if(board[i][Rj]=='p'){
                count++;
                break;
            }else if(board[i][Rj]=='B'){
                break;
            }
        }
        //往下面找
        for(int i=Ri+1;i<8;i++){
            if(board[i][Rj]=='p'){
                count++;
                break;
            }else if(board[i][Rj]=='B'){
                break;
            }
        }
        //往左边找
        for(int j=Rj-1;j>=0;j--){
            if(board[Ri][j]=='p'){
                count++;
                break;
            }else if(board[Ri][j]=='B'){
                break;
            }
        }
        //往右边找
        for(int j=Ri+1;j<8;j++){
            if(board[Ri][j]=='p'){
                count++;
                break;
            }else if(board[Ri][j]=='B'){
                break;
            }
        }
        return count;
    }

    @Test
    public void test1(){
        char[][] board = {{'.','.','.','.','.','.','.','.'}
        ,{'.','.','.','p','.','.','.','.'}
        ,{'.','.','.','p','.','.','.','.'}
        ,{'p','p','.','R','.','p','B','.'}
        ,{'.','.','.','.','.','.','.','.'}
        ,{'.','.','.','B','.','.','.','.'}
        ,{'.','.','.','p','.','.','.','.'}
        ,{'.','.','.','.','.','.','.','.'}};
        System.out.println(numRookCaptures(board));
    }
}
