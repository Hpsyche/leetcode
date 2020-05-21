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
public class Question145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()){
            TreeNode pop = stack1.pop();
            stack2.add(pop.val);
            if(pop.left!=null){
                stack1.add(pop.left);
            }
            if(pop.right!=null){
                stack1.add(pop.right);
            }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop());
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
        List<Integer> list = postorderTraversal(treeNode1);
        for(int i:list){
            System.out.println(i);
        }
    }
}
