package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/21
 */
public class Question144 {
    List<Integer> res=new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        prev(root);
        return res;
    }

    private void prev(TreeNode root) {
        if(root==null){
            return;
        }
        res.add(root.val);
        prev(root.left);
        prev(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right!=null){
                stack.add(pop.right);
            }
            if(pop.left!=null){
                stack.add(pop.left);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.right=treeNode2;
        treeNode2.left=treeNode3;
        List<Integer> list = preorderTraversal2(treeNode1);
        for(int i:list){
            System.out.println(i);
        }
    }
}
