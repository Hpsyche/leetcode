package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/13
 */
public class Question124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=Math.max(0,dfs(root.left));
        int right=Math.max(0,dfs(root.right));
        max=Math.max(max,left+right+root.val);
        return root.val+Math.max(left,right);
    }
}
