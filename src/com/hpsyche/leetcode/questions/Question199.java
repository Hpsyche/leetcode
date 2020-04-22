package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/4/22
 */
public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curr=queue.size();
            TreeNode outNode=null;
            while (curr>0) {
                outNode = queue.poll();
                if (outNode.left != null) {
                    queue.add(outNode.left);
                }
                if (outNode.right != null) {
                    queue.add(outNode.right);
                }
                curr--;
            }
            res.add(outNode.val);
        }
        return res;
    }

    @Test
    public void test(){
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        treeNode2.right=treeNode5;
        treeNode3.right=treeNode4;
        List<Integer> list = rightSideView(treeNode);
        for(int i:list){
            System.out.println(i);
        }
    }
}
