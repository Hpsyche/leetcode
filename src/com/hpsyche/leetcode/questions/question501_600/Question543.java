package com.hpsyche.leetcode.questions.question501_600;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/4
 */
public class Question543 {
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * 最大高度
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        //max为左右子树最高高度之和：left+right
        max=Math.max(max,left+right);
        //返回左右子树的最大高度
        return Math.max(left,right)+1;
    }

    @Test
    public void test1(){
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        System.out.println(diameterOfBinaryTree(treeNode));
    }
}
