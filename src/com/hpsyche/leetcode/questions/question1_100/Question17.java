package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/12
 */
public class Question17 {
    private String[] letterMap={
            " ",     //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private ArrayList<String> res;
    public List<String> letterCombinations(String digits) {
        res=new ArrayList<>();
        if(digits.equals("")){
            return res;
        }
        helper(digits,0,"");
        return res;
    }

    private void helper(String digits, int index, String s) {
        if(index==digits.length()){
            res.add(s);
            return;
        }
        char c=digits.charAt(index);
        String letter=letterMap[c-'0'];
        for(int i=0;i<letter.length();i++){
            helper(digits,index+1,s+letter.charAt(i));
        }
    }


    @Test
    public void test1(){
        letterCombinations("23");
    }
}
