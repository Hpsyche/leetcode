package com.hpsyche.leetcode.questions.question1101_1200;

/**
 * @author hpsyche
 * Create on 2020/5/5
 */
public class Question1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        int j=1;
        while (candies>0){
            for(int i=0;i<num_people&&candies>0;i++){
                if(candies>j){
                    res[i]+=j;
                }else{
                    res[i]+=candies;
                }
                candies-=j;
                j++;
            }
        }
        return res;
    }
}
