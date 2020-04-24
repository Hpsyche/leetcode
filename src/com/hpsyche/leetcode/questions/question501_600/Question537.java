package com.hpsyche.leetcode.questions.question501_600;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/1
 */
public class Question537 {
    public String complexNumberMultiply(String a, String b) {
        String[] aSplit = a.split("\\+");
        String[] bSplit = b.split("\\+");
        int aConst= Integer.parseInt(aSplit[0]);
        int bConst= Integer.parseInt(bSplit[0]);
        int aXu=Integer.parseInt(aSplit[1].split("i")[0]);
        int bXu=Integer.parseInt(bSplit[1].split("i")[0]);
        int getConst=aConst*bConst+(aXu*bXu*-1);
        int getXu=aConst*bXu+aXu*bConst;
        return getConst+"+"+getXu+"i";
    }

    @Test
    public void test1(){
        System.out.println(complexNumberMultiply("1+-1i","0+0i"));
    }
}
