package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/10
 */
public class Question116_2 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node prev=root;
        while (prev.left!=null){
            Node temp=prev;
            while (temp!=null){
                temp.left.next=temp.right;
                if(temp.next!=null){
                    temp.right.next=temp.next.left;
                }
                temp=temp.next;
            }
            prev=prev.left;
        }
        return root;
    }
}
