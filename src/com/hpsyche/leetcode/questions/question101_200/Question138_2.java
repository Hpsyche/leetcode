package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/19
 */
public class Question138_2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //克隆节点
        Node curr=head;
        while (curr!=null){
            Node temp=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=temp;
            curr=temp;
        }
        //random赋值
        curr=head;
        while (curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        //拆分节点
        curr=head;
        Node cloneHead=curr.next;
        Node cloneCurr=cloneHead;
        while (cloneCurr.next!=null){
            curr.next=curr.next.next;
            curr=curr.next;
            cloneCurr.next=cloneCurr.next.next;
            cloneCurr=cloneCurr.next;
        }
        //给原链表收尾
        curr.next=null;
        return cloneHead;
    }
}
