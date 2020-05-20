package com.hpsyche.leetcode.questions.question1301_1400;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/20
 */
public class Question1371 {
    public int findTheLongestSubstring(String s) {
        int[] prev=new int[32];
        for(int i=0;i<32;i++){
            prev[i]=Integer.MAX_VALUE;
        }
        prev[0]=-1;
        int curr=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'a':curr^=1;break;
                case 'e':curr^=2;break;
                case 'i':curr^=4;break;
                case 'o':curr^=8;break;
                case 'u':curr^=16;break;
                default:break;
            }
            if(prev[curr]==Integer.MAX_VALUE){
                prev[curr]=i;
            }else{
                res=Math.max(res,i-prev[curr]);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(findTheLongestSubstring("amntyyaw"));
    }

}
