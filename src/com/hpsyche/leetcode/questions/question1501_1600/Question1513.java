package com.hpsyche.leetcode.questions.question1501_1600;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/2
 */
public class Question1513 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int currI=0;
        int currJ=n-1;
        while(currI<m&&currJ>=0){
            if(matrix[currI][currJ]>target){
                currJ--;
            }else if(matrix[currI][currJ]<target){
                currI++;
            }else{
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        int[][] temp=new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(temp,20));
    }
}
