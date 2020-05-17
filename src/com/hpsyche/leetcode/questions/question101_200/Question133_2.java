package com.hpsyche.leetcode.questions.question101_200;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/5/17
 */
public class Question133_2 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node> map=new HashMap<>();
        Node clone=new Node(node.val,new ArrayList<>());
        map.put(node,clone);
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            for(Node n:poll.neighbors){
                if(!map.containsKey(n)){
                    map.put(n,new Node(n.val,new ArrayList<>()));
                    queue.add(n);
                }
                map.get(poll).neighbors.add(map.get(n));
            }
        }
        return clone;
    }
}
