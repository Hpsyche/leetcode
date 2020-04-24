package com.hpsyche.leetcode.questions.question401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/4/5
 */
public class Question460 {
    class Node{
        int key;
        int value;
        int count;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
    Map<Integer,Node> cache;
    Node head;
    Node tail;
    int capacity;
    int size;

    public Question460(int capacity) {
        cache=new HashMap<>(capacity);
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }

    public int get(int key) {
        Node node=cache.get(key);
        if(node==null){
            return -1;
        }
        node.count++;
        moveToNewPosition(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        Node node=cache.get(key);
        if(node!=null){
             node.value=value;
             node.count++;
             moveToNewPosition(node);
        }else{
            if(size==capacity){
                cache.remove(head.next.key);
                removeNode(head.next);
                size--;
            }
            Node newNode=new Node(key,value);
            addNode(newNode);
            cache.put(key,newNode);
            size++;
        }
    }

    private void addNode(Node node) {
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
        moveToNewPosition(node);
    }

    private void moveToNewPosition(Node node) {
        Node nextNode=node.next;
        removeNode(node);
        while (nextNode.count<=node.count&&nextNode!=tail){
            nextNode=nextNode.next;
        }
        nextNode.prev.next=node;
        node.prev=nextNode.prev;
        node.next=nextNode;
        nextNode.prev=node;
    }

    private void removeNode(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}
