package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/24
 */
public class Question74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int top=0;
        int bottom=m-1;
        while (top<=bottom){
            int mid=top+((bottom-top)>>1);
            if(matrix[mid][0]<target){
                top=mid+1;
            }else if(matrix[mid][0]>target){
                bottom=mid-1;
            }else{
                return true;
            }
        }
        if(bottom<0){
            return false;
        }
        int left=0;
        int right=n-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if(matrix[bottom][mid]<target){
                left=mid+1;
            }else if(matrix[bottom][mid]>target){
                right=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            int midElement=matrix[mid/n][mid%n];
            if(midElement==target){
                return true;
            }else if(midElement>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }


    @Test
    public void test1(){
//        int[][] matrix=new int[][]{
//                {1,3,5,6},{11,13,14,15},{16,17,19,20},{26,27,29,45}
//        };
        int[][] matrix=new int[][]{
                {1}
        };

        boolean b = searchMatrix(matrix, 0);
        System.out.println(b);
    }
}
