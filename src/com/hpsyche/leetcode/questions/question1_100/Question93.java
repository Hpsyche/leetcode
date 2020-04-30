package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/30
 */
public class Question93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        int len=s.length();
        if(len<4||len>12){
            return res;
        }
        LinkedList<String> list=new LinkedList<>();
        dfs(s,len,0,0,list,res);
        return res;
    }

    private void dfs(String s,int len,int curr,int count,LinkedList<String> list,List<String> res){
        if(curr==len){
            if(count==4){
                res.add(String.join(".",list));
            }
            return;
        }
        //每段不足1，或者每段大于3，返回
        if(len-curr<(4-count)||len-curr>3*(4-count)){
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(curr+i>=len){
                break;
            }
            int ifValid=judgeValid(s,curr,curr+i);
            if(ifValid!=-1){
                list.addLast(ifValid+"");
                dfs(s,len,curr+i+1,count+1,list,res);
                list.removeLast();
            }
        }
    }

    private int judgeValid(String s, int left, int right) {
        int len=right-left+1;
        // 大于 1 位的时候，不能以 0 开头
        if(len>1&&s.charAt(left)=='0'){
            return -1;
        }
        int res=0;
        for(int i=left;i<=right;i++){
            res=res*10+s.charAt(i)-'0';
        }
        if(res>255){
            return -1;
        }
        return res;
    }

    @Test
    public void test1(){
        List<String> list = restoreIpAddresses("25525511135");
        for(String s:list){
            System.out.println(s);
        }
    }
}
