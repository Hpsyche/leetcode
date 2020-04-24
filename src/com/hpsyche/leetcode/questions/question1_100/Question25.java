package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/14
 */
public class Question25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode tail=head;
        for(int i=0;i<k;i++){
            if(tail==null){
                return head;
            }
            tail=tail.next;
        }
        ListNode newHead=reverse(head,tail);
        head.next=reverseKGroup(tail,k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev=null;
        ListNode curr;
        while (head!=tail){
            curr=head.next;
            head.next=prev;
            prev=head;
            head=curr;
        }
        return prev;
    }


    @Test
    public void test1(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode listNode = reverseKGroup(l1, 3);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
