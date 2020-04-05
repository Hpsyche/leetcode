package com.hpsyche.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/1/24
 */
public class Question401 {
    public List<String> readBinaryWatch(int num) {
        List<String> resList=new ArrayList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(count1(i)+count1(j)==num){
                    resList.add(i+":"+(j<10?"0"+j:j));
                }
            }
        }
        return resList;
    }

    private int count1(int i) {
        int count=0;
        while (i!=0){
            i=i&(i-1);
            count++;
        }
        return count;
    }
}
