package com.hpsyche.leetcode.questions.question1401_1500;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/28
 */
public class Question1403 {
    public boolean oneEditAway(String first, String second) {
        int length1=first.length();
        int length2=second.length();
        int lenCha=length1-length2;
        if(lenCha>1||lenCha<-1){
            return false;
        }
        int count=0;
        for(int i=0,j=0;i<length1&&j<length2;i++,j++){
            if(first.charAt(i)!=second.charAt(j)){
                if(lenCha==1){
                    j--;
                }else if (lenCha==-1){
                    i--;
                }
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        System.out.println(oneEditAway("bteacher","tteacher"));
    }
}
