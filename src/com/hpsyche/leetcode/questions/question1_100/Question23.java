package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hpsyche
 * Create on 2020/4/14
 */
public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode(0);
        ListNode resBefore=head;
        PriorityQueue<ListNode> nums=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                nums.add(lists[i]);
            }
        }
        while (!nums.isEmpty()){
            ListNode node = nums.poll();
            head.next=node;
            head=head.next;
            if(node.next!=null){
                nums.add(head.next);
            }
        }
        return resBefore.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head=new ListNode(0);
        ListNode resBefore=head;
        PriorityQueue<Node> nums=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                nums.add(new Node(i,lists[i].val));
            }
        }
        while (!nums.isEmpty()){
            Node node = nums.poll();
            head.next=new ListNode(node.val);
            lists[node.listNum]=lists[node.listNum].next;
            if(lists[node.listNum]!=null){
                nums.add(new Node(node.listNum,lists[node.listNum].val));
            }
            head=head.next;
        }
        return resBefore.next;
    }

    class Node{
        int listNum;
        int val;

        public Node(int listNum, int val) {
            this.listNum = listNum;
            this.val = val;
        }
    }

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(5);
        l1.next=l2;
        l2.next=l3;

        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;

        ListNode l7=new ListNode(2);
        ListNode l8=new ListNode(6);
        l7.next=l8;

        ListNode[] listNodes=new ListNode[3];
        listNodes[0]=l1;
        listNodes[1]=l4;
        listNodes[2]=l7;

        ListNode listNode = mergeKLists(listNodes);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
}
