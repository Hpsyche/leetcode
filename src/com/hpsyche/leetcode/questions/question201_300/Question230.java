package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/8
 */
public class Question230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        int count=0;
        while (!stack.isEmpty()||root!=null){
            if(root!=null) {
                stack.push(root);
                root = root.left;
            }else{
                root=stack.pop();
                if(++count==k){
                    return root.val;
                }
                root=root.right;
            }
        }
        return -1;
    }
}
