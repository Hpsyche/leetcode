package com.hpsyche.leetcode.questions.question201_300;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/6/16
 */
public class Question297 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                sb.append("null,");
            } else {
                sb.append(root.val).append(",");
                queue.add(root.left);
                queue.add(root.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }



    public TreeNode deserialize(String data) {
        String[] nodes=data.substring(1,data.length()-1).split(",");
        TreeNode root=getNode(nodes[0]);
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode parent=root;
        boolean isLeft=true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode curr=getNode(nodes[i]);
            if(isLeft){
                parent.left=curr;
            }else{
                parent.right=curr;
            }
            isLeft=!isLeft;
            if(curr!=null){
                queue.add(curr);
            }
            if(isLeft){
                parent=queue.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if("null".equals(val)){
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        root.left = treeNode2;
        root.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        String serialize = serialize(root);
        System.out.println(serialize);
    }
}
