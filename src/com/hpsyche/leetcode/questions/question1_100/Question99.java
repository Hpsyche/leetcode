package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/2
 */
public class Question99 {
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorderTree(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void inorderTree(TreeNode root) {
        if(root==null){
            return;
        }
        inorderTree(root.left);
        if(first==null&&prev.val>root.val){
            first=prev;
        }
        if(first!=null&&prev.val>root.val){
            second=root;
        }
        prev=root;
        inorderTree(root.right);
    }
}
