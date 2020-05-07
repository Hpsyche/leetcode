package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/7
 */
public class Question106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length==0||postorder.length==0){
            return null;
        }
        return helper(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int inB, int inE,int[] postorder, int poE) {
        if(inB>inE){
            return null;
        }
        TreeNode root=new TreeNode(postorder[poE]);
        int i=0;
        for(;i<=inE;i++){
            if(inorder[i+inB]==postorder[poE]){
                break;
            }
        }
        root.left=helper(inorder,inB,inB+i-1,postorder,poE-(inE-(i+inB))-1);
        root.right=helper(inorder,inB+i+1,inE,postorder,poE-1);
        return root;
    }
}
