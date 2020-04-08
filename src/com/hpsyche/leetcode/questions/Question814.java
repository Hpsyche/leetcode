package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/8
 */
public class Question814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.left==null&&root.right==null&&root.val==0){
            return null;
        }
        return root;
    }

}
