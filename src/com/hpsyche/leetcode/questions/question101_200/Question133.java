package com.hpsyche.leetcode.questions.question101_200;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/5/17
 */
public class Question133 {
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
        Map<Node,Node> map=new HashMap<>();
        return dfs(node,map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone=new Node(node.val,new ArrayList<>());
        map.put(node,clone);
        for(Node n:node.neighbors){
            clone.neighbors.add(dfs(n,map));
        }
        return clone;
    }
}
