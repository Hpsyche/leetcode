package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/30
 */
public class Question95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list=new LinkedList<>();
        if(n==0){
            return list;
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> temp=new LinkedList<>();
        if(start>end){
            temp.add(null);
            return temp;
        }
        if(start==end){
            TreeNode treeNode=new TreeNode(start);
            temp.add(treeNode);
            return temp;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    temp.add(root);
                }
            }
        }
        return temp;
    }


    @Test
    public void test1(){
        List<TreeNode> list = generateTrees(3);
        for(TreeNode node:list){
            preorderTraversal2(node);
        }
    }


    public void preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        System.out.println();
    }
}
