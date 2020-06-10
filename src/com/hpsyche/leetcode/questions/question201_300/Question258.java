package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/10
 */
public class Question258 {
    public int addDigits(int num) {
        while (num>9){
            num%=9;
            if(num==0){
                return 9;
            }
        }
        return num;
    }
}
