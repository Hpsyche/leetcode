package com.hpsyche.leetcode;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/10
 */
public class Question606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb=new StringBuilder("");
        preTree(t,sb);
        return sb.toString();
    }

    private void preTree(TreeNode root, StringBuilder sb) {
        if(root==null){
            return;
        }
        sb.append(root.val);
        if(root.left!=null||root.right!=null){
            sb.append("(");
            preTree(root.left,sb);
            sb.append(")");
            if(root.right!=null) {
                sb.append("(");
                preTree(root.right, sb);
                sb.append(")");
            }
        }
    }

    @Test
    public void test1(){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        System.out.println(tree2str(root));
    }
}
