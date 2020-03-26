package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/26
 * 另一种方式：
 * 通过list
 * 1.初始化时存入空string
 * 2.遍历s，获取当前的rowNum，在list的index中，将string append s.charAt(i)
 */
public class Question6 {

    public String convert(String s, int numRows) {
        int numCols=getCols(s.length(),numRows);
        char[][] res=new char[numRows][numCols];
        StringBuilder sb=new StringBuilder("");
        if (numRows <= 1) {
            return s;
        }
        int step=-1;
        for(int i=0,j=0;i<s.length();i++,j=j+step){
            //求列号
            int column=getCols(i+1,numRows);
            //求行号
            if(i%(numRows-1)==0){
                step=step*-1;
            }
            res[j][column-1]=s.charAt(i);
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(res[i][j]!='\0'){
                    sb.append(res[i][j]);
                }
            }
        }
        return sb.toString();
    }

    private int getCols(int length, int numRows) {
        int count=0;
        while (length>0){
            length-=numRows;
            for(int i=0;i<numRows-2;i++){
                if(length>0){
                    length--;
                    count++;
                }else{
                    break;
                }
            }
            count++;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(convert("LEETCODEISHIRING",4));
//        System.out.println(convert());
//        System.out.println(getCols(13,6));
    }
}
