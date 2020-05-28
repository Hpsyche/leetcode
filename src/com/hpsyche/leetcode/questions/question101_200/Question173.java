package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/28
 */
public class Question173 {
    private TreeNode curr;
    private Stack<TreeNode> stack;
    public Question173(TreeNode root) {
        curr=root;
        stack=new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                curr = stack.pop();
                int result=curr.val;
                curr=curr.right;
                return result;
            }
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr!=null||!stack.isEmpty();
    }
}
