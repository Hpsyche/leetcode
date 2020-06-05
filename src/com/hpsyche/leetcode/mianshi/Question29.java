package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/5
 */
public class Question29 {
    int curr=0;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[]{};
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[] res=new int[m*n];
        int startX=0;
        int startY=0;
        int endX=m-1;
        int endY=n-1;
        while (startX<=endX&&startY<=endY){
            circleMatrix(matrix,res,startX,startY,endX,endY);
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return res;
    }

    private void circleMatrix(int[][] matrix, int[] res, int startX, int startY, int endX, int endY) {
        if(startX==endX){
            while (startY<=endY){
                res[curr++]=matrix[startX][startY++];
            }
        }else if(startY==endY){
            while (startX<=endX){
                res[curr++]=matrix[startX++][startY];
            }
        }else{
            int currX=startX;
            int currY=startY;
            while (currY<endY){
                res[curr++]=matrix[startX][currY++];
            }
            while (currX<endX){
                res[curr++]=matrix[currX++][endY];
            }
            while (currY>startY){
                res[curr++]=matrix[endX][currY--];
            }
            while (currX>startX){
                res[curr++]=matrix[currX--][startY];
            }
        }
    }

    @Test
    public void test1(){
        int[][] matrix=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        int[] ints = spiralOrder(matrix);
        for(int i:ints){
            System.out.println(i);
        }
    }
}
