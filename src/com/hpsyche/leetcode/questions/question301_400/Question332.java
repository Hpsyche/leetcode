package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/7/7
 */
public class Question332 {
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                map.get(ticket.get(0)).add(ticket.get(1));
            } else {
                List<String> list = new ArrayList<>();
                list.add(ticket.get(1));
                map.put(ticket.get(0), list);
            }
        }
        for(List<String> list:map.values()){
            list.sort(String::compareTo);
        }
        dfs(map, "JFK");
        return res;
    }

    private void dfs(Map<String, List<String>> map, String start) {
        List<String> list = map.get(start);
        while (list != null && list.size() > 0) {
            String dest = list.get(0);
            list.remove(0);
            dfs(map, dest);
        }
        res.add(0,start);
    }


    @Test
    public void test2() {
        System.out.println("SFO".compareTo("ABC"));
    }

    @Test
    public void test1() {
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("KUL");

        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("NRT");

        List<String> list3 = new ArrayList<>();
        list3.add("NRT");
        list3.add("JFK");

//        List<String> list4 = new ArrayList<>();
//        list4.add("ATL");
//        list4.add("JFK");
//
//        List<String> list5 = new ArrayList<>();
//        list5.add("ATL");
//        list5.add("SFO");

        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
//        list.add(list4);
//        list.add(list5);


        List<String> itinerary = findItinerary(list);
        for (String s : itinerary) {
            System.out.println(s);
        }
    }

}
