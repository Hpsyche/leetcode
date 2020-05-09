package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/9
 */
public class Question114_2 {
    private TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}
