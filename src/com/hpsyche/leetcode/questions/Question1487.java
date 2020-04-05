package com.hpsyche.leetcode.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/4
 */
public class Question1487 {
    private Integer capacity;
    private HashMap<Integer,Integer> map;
    private List<Integer> visitList;

    public Question1487(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>(capacity);
        visitList=new LinkedList<>();
    }

    public int get(int key) {
        Integer value = map.get(key);
        if(value==null){
            return -1;
        }else{
            visitList.remove(Integer.valueOf(key));
            visitList.add(visitList.size(),key);
        }
        return value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            visitList.remove(Integer.valueOf(key));
            visitList.add(visitList.size(), key);
        }else {
            if (visitList.size() >= capacity) {
                Integer num = visitList.remove(0);
                map.remove(num);
            }
            map.put(key, value);
            visitList.add(visitList.size(), key);
        }
    }


    public static void main(String[] args) {
        Question1487 question1487=new Question1487(2);
        question1487.put(2,1);
        question1487.put(1,1);
        question1487.put(2,3);
        question1487.put(4,1);
        System.out.println(question1487.get(1));;
        System.out.println(question1487.get(2));;
    }


}
