package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/3/17
 */
public class Question669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }
        if(root.val>=L&&root.val<=R){
            root.left=trimBST(root.left,L,R);
            root.right=trimBST(root.right,L,R);
        }else if(root.val<L){
            root=root.right;
            return trimBST(root,L,R);
        }else {
            root=root.left;
            return trimBST(root,L,R);
        }
        return root;
    }
}
