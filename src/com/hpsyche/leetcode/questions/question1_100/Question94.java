package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/30
 */
public class Question94 {
    List<Integer> res=new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new LinkedList<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        List<Integer> res=new LinkedList<>();
        stack1.add(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }

    @Test
    public void test1(){
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        treeNode.right=treeNode2;
        treeNode2.left=treeNode3;
        List<Integer> list = postorderTraversal2(treeNode);
        for(int i:list){
            System.out.println(i);
        }
    }
}
