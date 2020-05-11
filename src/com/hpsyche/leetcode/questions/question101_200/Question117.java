package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.Node;

/**
 * @author hpsyche
 * Create on 2020/5/11
 */
public class Question117 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            if(root.right!=null){
                root.left.next=root.right;
            }else{
                root.left.next=nextNode(root.next);
            }
        }
        if(root.right!=null){
            root.right.next=nextNode(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node nextNode(Node root) {
        while (root!=null){
            if(root.left!=null){
                return root.left;
            }
            if(root.right!=null){
                return root.right;
            }
            root=root.next;
        }
        return null;
    }
}
