package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/3/24
 */
public class Question337 {
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left!=null){
            if(root.right!=null) {
                return Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
                        , rob(root.left) + rob(root.right));
            }else{
                return Math.max(root.val + rob(root.left.left) + rob(root.left.right)
                        , rob(root.left) + rob(root.right));
            }
        }else{
            if(root.right!=null){
                return Math.max(root.val + rob(root.right.left) + rob(root.right.right)
                        , rob(root.left) + rob(root.right));
            }else{
                return Math.max(root.val,rob(root.left)+rob(root.right));
            }
        }
    }
}
