package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/2
 */
public class Question101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }

    @Test
    public void test1(){
        TreeNode listNode=new TreeNode(1);
        TreeNode listNode2=new TreeNode(2);
        TreeNode listNode3=new TreeNode(2);
        TreeNode listNode4=new TreeNode(3);
        TreeNode listNode5=new TreeNode(4);
        TreeNode listNode6=new TreeNode(4);
        TreeNode listNode7=new TreeNode(3);
        listNode.left=listNode2;
        listNode.right=listNode3;
        listNode2.left=listNode4;
        listNode2.right=listNode5;
        listNode3.left=listNode6;
        listNode3.right=listNode7;
        boolean symmetric = isSymmetric(listNode);
        System.out.println(symmetric);
    }
}
