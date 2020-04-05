package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/3/30
 */
public class Question700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }else if(root.val>val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
    }
}
