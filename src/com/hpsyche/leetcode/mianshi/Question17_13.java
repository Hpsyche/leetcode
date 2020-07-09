package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/7/9
 */
public class Question17_13 {
//    public int respace(String[] dictionary, String sentence) {
//        Arrays.sort(dictionary, Comparator.comparingInt(String::length));
//        for(int i=0;i<dictionary.length;i++){
//            for (int j = i+1; j < dictionary.length; j++) {
//                if("".equals(dictionary[i])){
//                    continue;
//                }
//                if(dictionary[j].contains(dictionary[i])){
//                    dictionary[j]=dictionary[j].replaceAll(dictionary[i],"");
//                }
//            }
//            sentence=sentence.replaceAll(dictionary[i],"");
//        }
//        return sentence.length();
//    }

    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int len=sentence.length();
        int[] dp=new int[len+1];
        for (int i = 1; i <= len; i++) {
            dp[i]=dp[i-1]+1;
            for (int j = 0; j < i; j++) {
                if(set.contains(sentence.substring(j,i))){
                    dp[i]=Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[len];
    }

    @Test
    public void test1(){
        String[] temp=new String[]{
                "looked","just","like","her","brother"
        };
        System.out.println(respace(temp,"jesslookedjustliketimherbrother"));
    }
}
