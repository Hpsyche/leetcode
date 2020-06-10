package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/10
 */
public class Question240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int currX=0;
        int currY=n-1;
        while (currX<m&&currY>-1){
            int curr=matrix[currX][currY];
            if(curr==target){
                return true;
            }else if(curr>target){
                currY--;
            }else{
                currX++;
            }
        }
        return false;
    }
}
