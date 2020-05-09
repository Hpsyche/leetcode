package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/9
 */
public class Question112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return root.val==sum;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
