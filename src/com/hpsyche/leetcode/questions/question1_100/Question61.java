package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/23
 */
public class Question61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        int count=1;
        ListNode curr=head;
        while (curr.next!=null){
            count++;
            curr=curr.next;
        }
        k%=count;
        if(k==0){
            return head;
        }
        curr.next=head;
        for(int i=0;i<count-k;i++){
            curr=curr.next;
        }
        ListNode newHead=curr.next;
        curr.next=null;
        return newHead;
    }


    @Test
    public void test1(){
        ListNode listNode=new ListNode(0);
        ListNode listNode2=new ListNode(1);
//        ListNode listNode3=new ListNode(2);
//        ListNode listNode4=new ListNode(4);
//        ListNode listNode5=new ListNode(5);
        listNode.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
        ListNode listNode1 = rotateRight(listNode, 17);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}
