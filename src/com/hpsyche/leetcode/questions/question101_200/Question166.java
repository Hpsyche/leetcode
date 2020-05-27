package com.hpsyche.leetcode.questions.question101_200;

import java.util.HashMap;

/**
 * @author hpsyche
 * Create on 2020/5/27
 */
public class Question166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num=numerator;
        long den=denominator;
        String sign;
        if (num > 0 && den < 0 || num < 0 && den > 0) {
            sign = "-";
        }else{
            sign = "";
        }
        num=Math.abs(num);
        den=Math.abs(den);
        long in=num/den;
        num-=in*den;
        HashMap<Long,Integer> map=new HashMap<>();
        StringBuilder decimal= new StringBuilder();
        int repeatIndex=-1;
        int index=0;
        while (num!=0){
            num*=10;
            if(map.containsKey(num)){
                repeatIndex=map.get(num);
                break;
            }
            map.put(num,index);
            long currDecimal=num/den;
            decimal.append(currDecimal);
            num-=currDecimal*den;
            index++;
        }
        if(repeatIndex!=-1){
            return sign+in+"."+decimal.substring(0,repeatIndex)+"("+decimal.substring(repeatIndex)+")";
        }else{
            if(decimal.toString().equals("")){
                return sign+in;
            }else{
                return sign+in+"."+decimal;
            }
        }
    }
}
