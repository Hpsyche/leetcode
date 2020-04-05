package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/22
 */
public class Question849 {
    public int maxDistToClosest(int[] seats) {
        int l=0;
        while (l<seats.length&&seats[l]==0){
            l++;
        }
        int r=seats.length-1;
        while (r>=0&&seats[r]==0){
            r--;
        }
        int borderMax=Math.max(l,seats.length-r-1);
        int middleMax=0;
        int currMiddleCount=0;
        for(int i=l;i<=r;i++){
            if(seats[i]==0){
                currMiddleCount++;
            }else{
                if(currMiddleCount>middleMax){
                    middleMax=currMiddleCount;
                }
                currMiddleCount=0;
            }
        }
        return Math.max(borderMax,(middleMax+1)/2);
    }

    @Test
    public void test1(){
        System.out.println(maxDistToClosest(new int[]{1,1,1,0,1,0,1,1,0,0,1}));
    }
}
