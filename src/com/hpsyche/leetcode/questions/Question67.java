package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/23
 */
public class Question67 {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int currA=charA.length-1;
        int currB=charB.length-1;
        StringBuilder sb=new StringBuilder("");
        int flag=0;
        while (currA>=0&&currB>=0){
            int sum=charA[currA]-'0'+charB[currB]-'0'+flag;
            if(sum>=2){
                sb.append(sum%2);
                flag=1;
            }else{
                sb.append(sum);
                flag=0;
            }
            currA--;
            currB--;
        }
        while (currA>=0){
            int sum=charA[currA]-'0'+flag;
            if(sum==2){
                sb.append("0");
                flag=1;
            }else{
                sb.append(sum);
                flag=0;
            }
            currA--;
        }
        while (currB>=0){
            int sum=charB[currB]-'0'+flag;
            if(sum==2){
                sb.append("0");
                flag=1;
            }else{
                sb.append(sum);
                flag=0;
            }
            currB--;
        }
        if(flag==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test1(){
        String s = addBinary("1111", "1111");
        System.out.println(s);
    }
}
