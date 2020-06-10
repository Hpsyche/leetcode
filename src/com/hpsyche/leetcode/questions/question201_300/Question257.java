package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/10
 */
public class Question257 {
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return res;
        }
        findPath(root,"");
        return res;
    }

    private void findPath(TreeNode root, String s) {
        if(root.left==null&&root.right==null){
            if(s.equals("")){
                res.add(root.val+"");
            }else {
                res.add(s + root.val);
            }
            return;
        }
        if(root.left!=null){
            findPath(root.left,s+root.val+"->");
        }
        if(root.right!=null){
            findPath(root.right,s+root.val+"->");
        }
    }

    @Test
    public void test1(){
        TreeNode treeNode1=new TreeNode(1);
//        TreeNode treeNode2=new TreeNode(2);
//        TreeNode treeNode3=new TreeNode(3);
//        TreeNode treeNode5=new TreeNode(5);
//        treeNode1.left=treeNode2;
//        treeNode1.right=treeNode3;
//        treeNode2.right=treeNode5;
        List<String> list = binaryTreePaths(treeNode1);
        for(String string:list){
            System.out.println(string);
        }
    }
}
