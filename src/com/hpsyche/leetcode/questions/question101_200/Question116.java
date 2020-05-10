//package com.hpsyche.leetcode.questions.question101_200;
//
//import com.sun.org.apache.regexp.internal.RE;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * @author hpsyche
// * Create on 2020/5/10
// */
//public class Question116 {
//    class Node {
//        public int val;
//        public Node left;
//        public Node right;
//        public Node next;
//
//        public Node() {}
//
//        public Node(int _val) {
//            val = _val;
//        }
//
//        public Node(int _val, Node _left, Node _right, Node _next) {
//            val = _val;
//            left = _left;
//            right = _right;
//            next = _next;
//        }
//    }
//
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        Queue<Node> queue=new LinkedList<>();
//        queue.add(root);
//        Node prev=null;
//        while (!queue.isEmpty()){
//            int count=queue.size();
//            while (count>0) {
//                Node poll = queue.poll();
//                count--;
//                poll.next=prev;
//                if(count>0){
//                    prev=poll;
//                }else{
//                    prev=null;
//                }
//                if(poll.right!=null){
//                    queue.add(poll.right);
//                }
//                if (poll.left!=null){
//                    queue.add(poll.left);
//                }
//            }
//        }
//        return root;
//    }
//}
