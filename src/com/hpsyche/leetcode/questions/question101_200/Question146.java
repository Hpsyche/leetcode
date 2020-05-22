package com.hpsyche.leetcode.questions.question101_200;

import com.sun.java.swing.plaf.windows.WindowsOptionPaneUI;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * @author hpsyche
 * Create on 2020/5/22
 */
public class Question146 {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
    private HashMap<Integer,Node> map;
    private int size;
    private int capacity;
    private Node head;
    private Node tail;
    public Question146(int capacity) {
        map=new HashMap<>();
        this.size=0;
        this.capacity=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        Node getNode=map.get(key);
        if(getNode!=null){
            moveNodeToHead(getNode);
            return getNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node getNode=map.get(key);
        if(getNode!=null){
            getNode.value=value;
            moveNodeToHead(getNode);
        }else{
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            addNodeToHead(newNode);
            ++size;
            if(size>capacity){
                Node node = removeTailNode();
                map.remove(node.key);
                size--;
            }
        }
    }

    private Node removeTailNode() {
        Node getNode=tail.prev;
        remove(getNode);
        return getNode;
    }

    private void moveNodeToHead(Node getNode) {
        remove(getNode);
        addNodeToHead(getNode);
    }

    private void addNodeToHead(Node getNode) {
        Node headNext=head.next;
        head.next=getNode;
        getNode.prev=head;
        getNode.next=headNext;
        headNext.prev=getNode;
    }

    private void remove(Node getNode) {
        Node prev=getNode.prev;
        Node next=getNode.next;
        prev.next=next;
        next.prev=prev;
    }

    public static void main(String[] args) {
        Question146 question146=new Question146(1);
        question146.put(2,1);
        question146.get(2);
        question146.put(3,2);
        int i = question146.get(2);
        System.out.println(i);

    }
}
