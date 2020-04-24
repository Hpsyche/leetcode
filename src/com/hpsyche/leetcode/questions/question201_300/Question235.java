package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2019/12/14
 *  二叉搜索树的最近
 */
public class Question235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val){
            return p;
        }
        if(root.val==q.val){
            return q;
        }
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
