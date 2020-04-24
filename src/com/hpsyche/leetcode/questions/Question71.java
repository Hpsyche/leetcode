package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/24
 */
public class Question71 {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        String[] str=path.split("/");
        for(String s:str){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals("")&&!s.equals(".")){
                stack.push(s);
            }
        }
        if ( stack.isEmpty() ) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (String s : stack) {
            ans.append("/").append(s);
        }
        return ans.toString();
    }

    @Test
    public void test1(){
        System.out.println(simplifyPath("/.."));
    }
}
