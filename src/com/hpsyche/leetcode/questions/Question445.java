package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/14
 */
public class Question445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> nums1=new Stack<>();
        Stack<Integer> nums2=new Stack<>();
        while (l1!=null){
            nums1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            nums2.push(l2.val);
            l2=l2.next;
        }
        ListNode after=null;
        ListNode curr=null;
        int f=0;
        while (!nums1.isEmpty()||!nums2.isEmpty()){
            int temp=f;
            if(!nums1.isEmpty()){
                temp+=nums1.pop();
            }
            if(!nums2.isEmpty()){
                temp+=nums2.pop();
            }
            if(temp>=10){
                f=1;
                temp-=10;
            }else{
                f=0;
            }
            curr=new ListNode(temp);
            curr.next=after;
            after=curr;
        }
        if(f==1){
            curr=new ListNode(1);
            curr.next=after;
        }
        return curr;
    }


    @Test
    public void test1(){
        ListNode l1=new ListNode(7);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        ListNode l4=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        ListNode l5=new ListNode(0);
//        ListNode l6=new ListNode(6);
//        ListNode l7=new ListNode(4);
//        ListNode l8=new ListNode(4);
//        l5.next=l6;
//        l6.next=l7;
//        l7.next=l8;

        ListNode listNode = addTwoNumbers(l1, l5);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
}
