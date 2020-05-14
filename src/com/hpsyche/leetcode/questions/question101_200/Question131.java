package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/5/14
 */
public class Question131 {
    List<List<String>> res=new LinkedList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new LinkedList<String>());
        return res;
    }

    private void dfs(String s, int begin, LinkedList<String> list) {
        if(begin==s.length()){
            res.add(new LinkedList<>(list));
        }
        for(int i=begin;i<s.length();i++){
            String curr = s.substring(begin, i+1);
            if (isHuiWen(curr)) {
                list.add(curr);
                dfs(s,i+1,list);
                list.removeLast();
            }
        }
    }

    private boolean isHuiWen(String s) {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test1(){
        List<List<String>> aab = partition("aab");
        System.out.println(aab);
    }
}
