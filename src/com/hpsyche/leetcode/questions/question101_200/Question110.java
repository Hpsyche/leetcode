package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/8
 */
public class Question110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftHigh=getHigh(root.left);
        int rightHigh=getHigh(root.right);
        if(Math.abs(leftHigh-rightHigh)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    private int getHigh(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(getHigh(root.left)+1,getHigh(root.right)+1);
    }

    public boolean isBalancedSecond(TreeNode root) {
        return helper(root)!=-1;
    }

    private int helper(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=helper(root.left);
        if(left==-1){
            return -1;
        }
        int right=helper(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
