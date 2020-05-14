package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/5/14
 */
public class Question129 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }

    private void helper(TreeNode root, int curr) {
        if(root==null){
            return;
        }
        int count=10*curr+root.val;
        if(root.left==null&&root.right==null){
            sum+=count;
        }
        helper(root.left,count);
        helper(root.right,count);
    }
}
