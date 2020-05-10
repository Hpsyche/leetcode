package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/10
 */
public class Question236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else if(right!=null){
            return right;
        }
        return null;
    }
}
