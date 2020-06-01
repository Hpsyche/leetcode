package com.hpsyche.leetcode.questions.question1401_1500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/1
 */
public class Question1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list=new ArrayList<>(candies.length);
        int maxCandie=candies[0];
        for(int candie:candies){
            maxCandie=Math.max(candie,maxCandie);
        }
        for(int candie:candies){
            if((candie+extraCandies)<maxCandie){
                list.add(false);
            }else{
                list.add(true);
            }
        }
        return list;
    }

    @Test
    public void test1(){
        List<Boolean> booleans = kidsWithCandies(new int[]{10,1}, 3);
        for(boolean b:booleans){
            System.out.println(b);
        }
    }
}
