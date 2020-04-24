package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/18
 */
public class Question38 {
    public String countAndSay(int n) {
        String prev="1";
        for(int i=1;i<n;i++){
            StringBuilder temp=new StringBuilder("");
            int curr=0;
            while (curr<prev.length()){
                char c = prev.charAt(curr);
                int count=0;
                for(;curr<prev.length();){
                    if(prev.charAt(curr)==c){
                        count++;
                        curr++;
                    }else{
                        break;
                    }
                }
                temp.append(count).append(c);
            }
            prev=temp.toString();
        }
        return prev;
    }

    @Test
    public void test1(){
//        countAndSay(2);
//        System.out.println(countAndSay(3));
//        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
//        System.out.println(countAndSay(6));
//        System.out.println(countAndSay(7));
    }
}
