package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/24
 */
public class Question149 {
    public int maxPoints(int[][] points) {
        int res=0;
        int len=points.length;
        if(len<3){
            return len;
        }
        for(int i=0;i<len;i++){
            Map<String,Integer> map=new HashMap<>();
            int count=0;
            int duplicate=0;
            for(int j=i+1;j<len;j++){
                int dx=points[i][0]-points[j][0];
                int dy=points[i][1]-points[j][1];
                if(dx==0&&dy==0){
                    duplicate++;
                    continue;
                }
                int gcd=gcd(dx,dy);
                dx/=gcd;
                dy/=gcd;
                String key=dx+"/"+dy;
                map.put(key,map.getOrDefault(key,0)+1);
                count=Math.max(count,map.get(key));
            }
            res=Math.max(res,count+duplicate+1);
        }
        return res;
    }

//    @Test
//    public void test1(){
//        System.out.println(gcd(4,0));
//    }

    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
