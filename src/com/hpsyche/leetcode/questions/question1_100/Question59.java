package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/22
 */
public class Question59 {
    int count=0;
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int bX=0;
        int bY=0;
        int eX=n-1;
        int eY=n-1;
        while (bX<=eX&&bY<=eY){
            addOrder(res,bX++,bY++,eX--,eY--);
        };
        return res;
    }

    private void addOrder(int[][] res,int bX, int bY, int eX, int eY) {
        if(bX==eX){
            for(int i=bY;i<=eY;i++){
                res[bX][i]=++count;
            }
            return;
        }
        if(bY==eY){
            for(int i=bX;i<=eX;i++){
                res[i][bY]=++count;
            }
            return;
        }
        for(int i=bY;i<eY;i++){
            res[bX][i]=++count;
        }
        for(int i=bX;i<eX;i++){
            res[i][eY]=++count;
        }
        for(int i=eY;i>bY;i--){
            res[eX][i]=++count;
        }
        for(int i=eX;i>bX;i--){
            res[i][bY]=++count;
        }
    }

    @Test
    public void test1(){
        int[][] ints = generateMatrix(3);
        for(int[] is:ints){
            for(int i:is){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
