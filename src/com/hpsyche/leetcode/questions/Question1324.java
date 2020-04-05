package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/3/13
 * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 *
 */
public class Question1324 {
    public List<String> printVertically(String s) {
        String[] strings = s.split(" ");
        List<String> resList=new ArrayList<>();
        int currIndex=0;
        boolean flag=true;
        while(flag) {
            flag=false;
            StringBuilder sb=new StringBuilder("");
            for (String str : strings) {
                if (currIndex < str.length()) {
                    System.out.println(currIndex);
                    sb.append(str.charAt(currIndex));
                    flag=true;
                }else{
                    sb.append(" ");
                }
            }
            currIndex++;
            if(!sb.toString().trim().equals("")){
                resList.add(trimEnd(sb.toString().toCharArray()));
            }
        }
        return resList;
    }

    public String trimEnd(char[] value) {
        int len = value.length;
        int st = 0;
        char[] val = value;
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? new String(val).substring(st, len) : new String(val);
    }




    @Test
    public void test1(){
        List<String> strings = printVertically("HOW ARE YOU");
        for(String s:strings){
            System.out.println(s);
        }
    }

}
