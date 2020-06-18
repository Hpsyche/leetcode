package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/18
 */
public class Question299 {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int[] counts=new int[10];
        for(int i=0;i<secret.length();i++){
            counts[secret.charAt(i)-'0']++;
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }
        }
        int cows=-bulls;
        for(int i=0;i<guess.length();i++){
            if(counts[guess.charAt(i)-'0']-->0){
                cows++;
            }
        }
        return bulls+"A"+cows+"B";
    }

    @Test
    public void test1(){
        getHint("1807","7810");
        System.out.println(getHint("2","2"));
    }
}
