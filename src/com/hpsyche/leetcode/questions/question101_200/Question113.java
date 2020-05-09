package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/5/9
 */
public class Question113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Deque<Integer> path=new ArrayDeque<>();
        dfs(root,sum,res,path);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, Deque<Integer> path) {
        sum-=root.val;
        path.addLast(root.val);
        if(root.left==null&&root.right==null&&sum==0){
            res.add(new LinkedList<>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left, sum, res, path);
            path.removeLast();
        }
        if(root.right!=null) {
            dfs(root.right, sum, res, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_ = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_ = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_;
        treeNode4_.left = treeNode5_;
        treeNode4_.right = treeNode1;

        Question113 solution = new Question113();
        List<List<Integer>> res = solution.pathSum(treeNode5, 22);
        System.out.println(res);

    }
}
