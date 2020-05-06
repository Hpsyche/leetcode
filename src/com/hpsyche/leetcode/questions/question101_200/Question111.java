package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/6
 */
public class Question111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right!=null){
            return 1+minDepth(root.right);
        }
        if(root.right==null&&root.left!=null){
            return 1+minDepth(root.left);
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
