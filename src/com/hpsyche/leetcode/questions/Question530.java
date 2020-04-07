package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/4/7
 */
public class Question530 {
    private int result=Integer.MAX_VALUE;
    private TreeNode prev=null;
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return result;
    }

    private void getMin(TreeNode root) {
        if(root==null){
            return;
        }
        getMin(root.left);
        if(prev!=null){
            result=Math.min(root.val-prev.val,result);
        }
        prev=root;
        getMin(root.right);
    }
}
