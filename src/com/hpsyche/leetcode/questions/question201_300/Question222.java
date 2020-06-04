package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/6/4
 */
public class Question222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        if(leftDepth==rightDepth){
            return (1<<leftDepth)+countNodes(root.right);
        }
        return (1<<rightDepth)+countNodes(root.left);
    }

    private int getDepth(TreeNode root){
        int depth=0;
        while (root!=null){
            depth++;
            root=root.left;
        }
        return depth;
    }
}
