package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/9
 */
public class Question114 {
    public void flatten(TreeNode root) {
        while (root!=null){
            if(root.left==null){
                root=root.right;
            }else{
                //找子树最右边的节点（以便接后面的节点）
                TreeNode prev=root.left;
                while (prev.right!=null){
                    prev=prev.right;
                }
                prev.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }
}
