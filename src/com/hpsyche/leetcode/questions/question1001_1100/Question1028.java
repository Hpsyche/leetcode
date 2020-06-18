package com.hpsyche.leetcode.questions.question1001_1100;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/18
 */
public class Question1028 {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack=new Stack<>();
        int index=0;
        while (index<S.length()){
            //层数
            int level=0;
            while (S.charAt(index)=='-'){
                level++;
                index++;
            }
            //数字
            int num=0;
            while (index<S.length()&&S.charAt(index)!='-'){
                num=num*10+(S.charAt(index)-'0');
                index++;
            }
            while (stack.size()>level){
                stack.pop();
            }
            TreeNode newNode=new TreeNode(num);
            if(!stack.isEmpty()){
                if(stack.peek().left==null){
                    stack.peek().left=newNode;
                }else{
                    stack.peek().right=newNode;
                }
            }
            stack.push(newNode);
        }
        while (stack.size()>1){
            stack.pop();
        }
        return stack.pop();
    }

}
