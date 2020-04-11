package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/4/11
 */
public class Question12 {
    public String intToRoman(int num) {
        int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder("");
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }
}
