package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/2
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag=0;
        ListNode head=new ListNode(-1);
        ListNode res=head;
        while (l1!=null||l2!=null){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int sum=num1+num2+flag;
            flag=sum/10;
            ListNode next=new ListNode(sum%10);
            head.next=next;
            head=next;
            if(l1!=null) {
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
        }
        if(flag>0){
            head.next=new ListNode(flag);
        }
        return res.next;
    }

    @Test
    public void test1(){
        ListNode listNode=new ListNode(2);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6);
        ListNode listNode6=new ListNode(4);
        listNode.next=listNode2;
        listNode2.next=listNode3;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        ListNode listNode1 = addTwoNumbers(listNode, listNode4);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}
