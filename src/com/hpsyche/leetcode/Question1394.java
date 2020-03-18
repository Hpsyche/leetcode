package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/16
 */
public class Question1394 {
    public String compressString(String S) {
        StringBuilder str=new StringBuilder("");
        if(S.length() == 0){
            return S;
        }
        int count=1;
        str.append(S.charAt(0));
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)!=S.charAt(i-1)){
                str.append(count);
                str.append(S.charAt(i));
                count=1;
            }else{
                count++;
            }
        }
        str.append(count);
        return str.length()<S.length()?str.toString():S;
    }

    @Test
    public void test(){
        System.out.println(compressString("abbccd"));
    }
}
