package com.hpsyche.leetcode.questions.question401_500;

/**
 * @author hpsyche
 * Create on 2020/5/31
 */
public class Question476 {
    public int findComplement(int num) {
        int temp=num;
        int allOneNum=1;
        while (temp>0){
            temp>>=1;
            allOneNum<<=1;
        }
        allOneNum-=1;
        return num^allOneNum;
    }
}
