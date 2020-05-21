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
public class Question144_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
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

    @Test
    public void test1(){
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.right=treeNode2;
        treeNode2.left=treeNode3;
        List<Integer> list = inorderTraversal(treeNode1);
        for(int i:list){
            System.out.println(i);
        }

    }
}
